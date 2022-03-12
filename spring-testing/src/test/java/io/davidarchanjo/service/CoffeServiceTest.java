package io.davidarchanjo.service;

import io.davidarchanjo.repository.CoffeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CoffeServiceTest {

    @InjectMocks
    private CoffeeService coffeeService;

    @Mock
    private CoffeeRepository coffeeRepository;

    @Test
    void testGetCoffee() {
        when(coffeeRepository.findByName(anyString()))
            .thenReturn("mocha");

        assertEquals("mocha", coffeeService.getCoffee("david"));
    }

}
