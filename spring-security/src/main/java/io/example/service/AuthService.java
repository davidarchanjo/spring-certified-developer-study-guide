package io.example.service;

import io.example.model.dto.UserDTO;

public interface AuthService {
    UserDTO login(String username, String password);
}