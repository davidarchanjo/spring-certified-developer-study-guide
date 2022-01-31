package io.davidarchanjo.service;

import io.davidarchanjo.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public String getCoffee(String name){
        return coffeeRepository.findByName(name);
    }
}