package io.davidarchanjo.code.service.impl;

import io.davidarchanjo.code.service.GreetingService;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    @Transactional
    public String greet() {
        return "Hello, World";
    }
}