package io.davidarchanjo;

import io.davidarchanjo.service.CoffeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringBootTestTest {

    @Autowired
    private CoffeeService coffeeService;

    @Test
    void getCoffeeTest() {
        String value = coffeeService.getCoffee("mocha");
        assertEquals("mocha", value);
    }

    @Test
    void getFooBarTest() {
        String value = coffeeService.getFooBar();
        assertEquals("foo", value);
    }
}