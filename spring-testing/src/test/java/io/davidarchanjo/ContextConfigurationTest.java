package io.davidarchanjo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.davidarchanjo.repository.impl.SimpleCoffeeRepository;
import io.davidarchanjo.service.CoffeeService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SimpleCoffeeRepository.class, CoffeeService.class})
class ContextConfigurationTest {

    @Autowired
    private CoffeeService coffeeService;

    @Test
    void getCoffeeTest() {
        String value = coffeeService.getCoffee("mocha");
        assertEquals("mocha", value);
    }
}