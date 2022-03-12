package io.davidarchanjo;

import io.davidarchanjo.config.AppConfig;
import io.davidarchanjo.repository.impl.SimpleCoffeeRepository;
import io.davidarchanjo.service.CoffeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SimpleCoffeeRepository.class, CoffeeService.class, AppConfig.class })
class ContextConfigurationTest {

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