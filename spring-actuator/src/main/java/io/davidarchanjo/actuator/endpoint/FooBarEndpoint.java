package io.davidarchanjo.actuator.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
@Endpoint(id = "foo-bar")
public class FooBarEndpoint {

    @ReadOperation
    public Map status() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("custom-status", "Everything looks healthy!");
        return result;
    }

    @ReadOperation
    public Map customOperation(@Selector String name) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("hello-world", name);
        return result;
    }

    @WriteOperation
    public void writeOperation(@Selector String name) {
        log.info("Write Operation - {}", name);
    }

    @DeleteOperation
    public void deleteOperation(@Selector String name) {
        log.info("Delete Operation - {}", name);
    }
}