package io.davidarchanjo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.davidarchanjo.model.domain.User;
import io.davidarchanjo.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    
    public void insertUser(User user) {
        repository.save(user);
    }
	
    public User getUserById(long userId) {        
        return repository.findById(userId).get();
    }
	
    public User getUserByName(String name) {
        return repository.findByName(name);
    }
	
    public List<User> getUsers() {
        return repository.findAll();
    }
}
