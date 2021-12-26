package io.example.service.impl;

import io.example.mapper.UserMapper;
import io.example.model.dto.CreateUserDTO;
import io.example.model.dto.UpdateUserDTO;
import io.example.model.dto.UserDTO;
import io.example.repository.UserRepository;
import io.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDTO create(CreateUserDTO createUserDTO) {
        if (userRepo.findByUsername(createUserDTO.getUsername()).isPresent()) {
            throw new ValidationException(String.format("Username - %s, already exists", createUserDTO.getUsername()));
        }
        return Optional.of(createUserDTO)
            .map(userMapper::create)
            .map(userRepo::save)
            .map(userMapper::build)
            .get();
    }

    @Override
    @Transactional
    public UserDTO update(Long userId, UpdateUserDTO updateUserDTO) {
        return userRepo.findById(userId)
            .map(o -> userMapper.build(updateUserDTO, o))
            .map(userRepo::save)
            .map(userMapper::build)
            .orElseThrow(() -> new UsernameNotFoundException(format("User with id - %s, not found", userId)));
    }

    @Override
    @Transactional
    public UserDTO upsert(CreateUserDTO createUserDTO) {
        final AtomicReference<UserDTO> dto = new AtomicReference<>();
        userRepo.findByUsername(createUserDTO.getUsername())
            .ifPresentOrElse(
                user -> {
                    final UpdateUserDTO updateUserDTO = new UpdateUserDTO();
                    updateUserDTO.setFullName(createUserDTO.getFullName());
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
            .map(userMapper::build)
            .orElseThrow(() -> new UsernameNotFoundException(format("User id - %s, not found", userId)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(format("User with username - %s, not found", username)));
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepo.findByUsername(username).isPresent();
    }

    @Override
    public UserDTO getUser(Long userId) {
        return userRepo.findById(userId)
            .map(userMapper::build)
            .orElseThrow(() -> new UsernameNotFoundException(format("User id - %s, not found", userId)));
    }

}
