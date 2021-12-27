package io.davidarchanjo.code.service;

import io.davidarchanjo.code.model.domain.Role;

public interface RoleService {

    void create(String name);
    Role findByName(String name);
}
