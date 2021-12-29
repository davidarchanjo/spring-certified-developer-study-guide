package io.davidarchanjo.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@SpringBootApplication
public class SpringTransactionalApplication {

    public static void main(String... args) {
        SpringApplication.run(SpringActuatorApplication.class, args);
    }

    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
