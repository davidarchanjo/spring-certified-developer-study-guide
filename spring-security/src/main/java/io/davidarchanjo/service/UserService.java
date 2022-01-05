package io.davidarchanjo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import io.davidarchanjo.model.dto.CreateUserDTO;
import io.davidarchanjo.model.dto.UpdateUserDTO;
import io.davidarchanjo.model.dto.UserDTO;

public interface UserService extends UserDetailsService {

    UserDTO create(CreateUserDTO request);
    UserDTO update(Long id, UpdateUserDTO request);
    UserDTO upsert(CreateUserDTO request);
    UserDTO delete(Long id);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    boolean usernameExists(String username);
    UserDTO getUser(Long id);

}
