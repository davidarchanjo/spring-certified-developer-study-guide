package io.davidarchanjo.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.davidarchanjo.enums.Roles;

@RestController
@RequestMapping("api/books")
public class BookController {

    @GetMapping
    public List findAll() {
        return List.of("Book 1", "Book 2", "Book 3");
    }

    @GetMapping("{id}")
    public String findById() {
        return "Book Found!";
    }

    @RolesAllowed(Roles.BOOK_ADMIN) // or @PreAuthorize("hasRole('BOOK_ADMIN')")
    @PostMapping
    public String create(Object dto) {
        return "New Book Created!";
    }

}
