package io.davidarchanjo.service;

import io.davidarchanjo.model.domain.Role;

public interface RoleService {

    void create(String name);
    Role findByName(String name);
}
