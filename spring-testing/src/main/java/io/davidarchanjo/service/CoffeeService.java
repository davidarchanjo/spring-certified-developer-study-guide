package io.davidarchanjo.service;

import io.davidarchanjo.model.TheBean;
import io.davidarchanjo.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired(required = false)
    private TheBean theBean;

    public String getCoffee(String name){
        return coffeeRepository.findByName(name);
    }

    public String getFooBar(){
        return theBean.getName();
    }
}