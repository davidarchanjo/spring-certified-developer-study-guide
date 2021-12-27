package io.davidarchanjo.code.service;

import io.davidarchanjo.code.model.dto.UserDTO;

public interface AuthService {
    UserDTO login(String username, String password);
}