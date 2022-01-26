package io.davidarchanjo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.davidarchanjo.bar.domain.Bar;
import io.davidarchanjo.bar.repo.BarRepository;
import io.davidarchanjo.foo.domain.Foo;
import io.davidarchanjo.foo.repo.FooRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("foobar")
@RequiredArgsConstructor
public class FooBarController {

    private final FooRepository fooRepo;
    private final BarRepository barRepo;

    @GetMapping("{id}")
    public String fooBar(@PathVariable Long id) {
        Foo foo = fooRepo.findById(id).orElseGet(() -> Foo.builder().build());
        Bar bar = barRepo.findById(id).orElseGet(() -> Bar.builder().build());
        return foo.getName() + " " + bar.getName();
    }
}