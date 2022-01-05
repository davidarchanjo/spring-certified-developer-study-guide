package io.davidarchanjo.service.impl;

import io.davidarchanjo.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet() {
        return "Hello, World";
    }
}