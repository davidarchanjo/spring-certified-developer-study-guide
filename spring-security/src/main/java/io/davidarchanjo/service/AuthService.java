package io.davidarchanjo.service;

import io.davidarchanjo.model.dto.UserDTO;

public interface AuthService {
    UserDTO login(String username, String password);
}