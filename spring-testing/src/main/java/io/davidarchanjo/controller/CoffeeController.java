package io.davidarchanjo.controller;

import io.davidarchanjo.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @GetMapping
    public String get() {
        return coffeeService.getCoffee("mocha");
    }
}
