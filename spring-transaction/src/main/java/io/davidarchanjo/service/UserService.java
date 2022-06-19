package io.davidarchanjo.service;

import io.davidarchanjo.model.domain.User;
import io.davidarchanjo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    
    public User insertUser(User user) {
        return repository.save(user);
    }
}
