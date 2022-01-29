package io.davidarchanjo.service.impl;

import io.davidarchanjo.builder.UserBuilder;
import io.davidarchanjo.model.dto.UserDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.davidarchanjo.model.domain.User;
import io.davidarchanjo.service.AuthService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserBuilder userBuilder;
    private final AuthenticationManager authManager;

    @Override
    public UserDTO login(String username, String password) {
        final Authentication authenticate = authManager
            .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        final User user = (User) authenticate.getPrincipal();
        return userBuilder.build(user);
    }    
    
}