package io.davidarchanjo.builder;

import io.davidarchanjo.model.domain.Role;
import io.davidarchanjo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoleBuilder {

    private final RoleService roleService;

    public Role build(String name) {
        return roleService.findByName(name);
    }

}
