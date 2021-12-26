package io.example.mapper;

import io.example.model.domain.User;
import io.example.model.dto.CreateUserDTO;
import io.example.model.dto.UpdateUserDTO;
import io.example.model.dto.UserDTO;
import io.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final UserRepository userRepo;
    private final RoleMapper roleMapper;
    private final PasswordEncoder passwordEncoder;

    public User create(CreateUserDTO request) {
        return User.builder()
            .username(request.getUsername())
            .fullName(request.getFullName())
            .password(passwordEncoder.encode(request.getPassword()))
            .authorities(Stream.of(request)
                .map(CreateUserDTO::getAuthorities)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .map(roleMapper::build)
                .collect(Collectors.toSet()))
            .build();
    }

    public User build(UpdateUserDTO request, User user) {
        Optional.ofNullable(request.getAuthorities())
            .ifPresent(o -> user.toBuilder()
                .authorities(o.stream()
                    .map(roleMapper::build)
                    .collect(Collectors.toSet())));

        Optional.ofNullable(request.getFullName())
            .ifPresent(o -> user.toBuilder().fullName(o));
        return user;
    }

    public UserDTO build(User domain) {
        return UserDTO.builder()
            .id(domain.getId())
            .username(domain.getUsername())
            .fullName(domain.getFullName())
            .build();
    }

    public List<UserDTO> build(List<User> users) {
        return users.stream()
            .map(this::build)
            .collect(Collectors.toList());
    }

    public UserDTO build(Long id) {
        return userRepo.findById(id)
            .map(this::build)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with id - %s, not found", id)));
    }

}
