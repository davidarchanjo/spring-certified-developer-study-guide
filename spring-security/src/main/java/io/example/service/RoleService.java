package io.example.service;

import io.example.model.domain.Role;

public interface RoleService {

    void create(String name);
    Role findByName(String name);
}
