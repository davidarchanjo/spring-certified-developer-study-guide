package io.davidarchanjo.controller;

import io.davidarchanjo.enums.Roles;
import io.davidarchanjo.model.domain.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("api/public")
public class PublicController {

    @RequestMapping
    public String helloAll() {
        return "Hello All";
    }

    // @Secured({Roles.USER_ADMIN, Roles.AUTHOR_ADMIN})
    // or @RolesAllowed({Roles.USER_ADMIN, Roles.AUTHOR_ADMIN})
    // or @PreAuthorize("hasRole('USER_ADMIN') or hasRole('AUTHOR_ADMIN')")
    @GetMapping("get")
    public String helloGet() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello " + user.getFullName();
    }

    @PostMapping("post")
    public String helloPost() {
        return "Hello Post";
    }

    @PutMapping("put")
    public String helloPut() {
        return "Hello Put";
    }

}
