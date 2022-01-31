package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@Slf4j
@SpringBootApplication
public class SpringStartupApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStartupApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner2() {
        return args -> log.info("Bean CommandLineRunner2: {}", String.join(",", args));
    }

    @Bean
    CommandLineRunner commandLineRunner1() {
        return args -> log.info("Bean CommandLineRunner1: {}", String.join(",", args));
    }

    @Bean
    ApplicationRunner applicationRunner2() {
        return args -> log.info("Bean ApplicationRunner2: {}", String.join(",", args.getSourceArgs()));
    }

    @Bean
    ApplicationRunner applicationRunner1() {
        return args -> log.info("Bean ApplicationRunner1: {}", String.join(",", args.getSourceArgs()));
    }
}
