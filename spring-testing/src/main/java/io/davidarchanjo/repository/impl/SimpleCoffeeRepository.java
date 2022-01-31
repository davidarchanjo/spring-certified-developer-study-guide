package io.davidarchanjo.repository.impl;

import io.davidarchanjo.repository.CoffeeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleCoffeeRepository implements CoffeeRepository {

    @Override
    public String findByName(String name) {
        return name;
    }
}