package io.davidarchanjo.controller;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    
    // @RequestMapping(value = "test", method = RequestMethod.POST, headers = "foo=bar")
    @GetMapping("test")
    public HttpEntity<String> handleTestRequest() {
        var headers = new HttpHeaders();
        headers.put("X-Foo", List.of("Z-Bar"));
        return new HttpEntity<>("test body", headers);
    }
}