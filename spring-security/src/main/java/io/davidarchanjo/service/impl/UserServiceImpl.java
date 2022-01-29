package io.davidarchanjo.service.impl;

import io.davidarchanjo.builder.UserBuilder;
import io.davidarchanjo.model.dto.CreateUserDTO;
import io.davidarchanjo.model.dto.UpdateUserDTO;
import io.davidarchanjo.model.dto.UserDTO;
import io.davidarchanjo.repository.UserRepository;
import io.davidarchanjo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final UserBuilder userBuilder;

    @Override
    @Transactional
    public UserDTO create(CreateUserDTO createUserDTO) {
        if (userRepo.findByUsername(createUserDTO.getUsername()).isPresent()) {
            throw new ValidationException(String.format("Username with name - %s, already exists", createUserDTO.getUsername()));
        }
        return Optional.of(createUserDTO)
            .map(userBuilder::create)
            .map(userRepo::save)
            .map(userBuilder::build)
            .get();
    }

    @Override
    @Transactional
    public UserDTO update(Long userId, UpdateUserDTO updateUserDTO) {
        return userRepo.findById(userId)
            .map(o -> userBuilder.build(updateUserDTO, o))
            .map(userRepo::save)
            .map(userBuilder::build)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with id - %s, not found", userId)));
    }

    @Override
    @Transactional
    public UserDTO upsert(CreateUserDTO createUserDTO) {
        final AtomicReference<UserDTO> dto = new AtomicReference<>();
        userRepo.findByUsername(createUserDTO.getUsername())
            .ifPresentOrElse(
                user -> {
                    UpdateUserDTO updateUserDTO = UpdateUserDTO.builder()
                        .fullName(createUserDTO.getFullName())
                        .build();
                    dto.set(update(user.getId(), updateUserDTO));
                },
                () -> dto.set(create(createUserDTO)));
        return dto.get();
    }

    @Override
    @Transactional
    public UserDTO delete(Long userId) {
        return userRepo.findById(userId)
            .map(o -> o.toBuilder()
                .username(o.getUsername().replace("@", String.format("_%s@", o.getId().toString())))
                .enabled(false)
                .build())
            .map(userRepo::save)
            .map(userBuilder::build)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with id - %s, not found", userId)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with name - %s, not found", username)));
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepo.findByUsername(username).isPresent();
    }

    @Override
    public UserDTO getUser(Long userId) {
        return userRepo.findById(userId)
            .map(userBuilder::build)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with id - %s, not found", userId)));
    }

}
