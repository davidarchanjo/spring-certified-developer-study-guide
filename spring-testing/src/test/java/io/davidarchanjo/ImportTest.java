package io.davidarchanjo;

import io.davidarchanjo.repository.impl.SimpleCoffeeRepository;
import io.davidarchanjo.service.CoffeeService;
import io.foobar.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@Import({ SimpleCoffeeRepository.class, CoffeeService.class, AppConfig.class })
class ImportTest {

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
        assertEquals("bar", value);
    }
}