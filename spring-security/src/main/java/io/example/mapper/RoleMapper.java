package io.example.mapper;

import io.example.model.domain.Role;
import io.example.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoleMapper {

    private final RoleService roleService;

    public Role build(String name) {
        return roleService.findByName(name);
    }

}
