package io.davidarchanjo.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.davidarchanjo.enums.Roles;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    @GetMapping
    public List findAll() {
        return List.of("William Shakespeare", "Emily Dickinson", "H. P. Lovecraft");
    }

    @GetMapping("{id}")
    public String findById(String id) {
        return "Author Found " + id + "!";
    }

    @RolesAllowed(Roles.AUTHOR_ADMIN) // or @PreAuthorize("hasRole('AUTHOR_ADMIN')")
    @PostMapping
    public String create(Object dto) {
        return "New Author Created!";
    }

}
