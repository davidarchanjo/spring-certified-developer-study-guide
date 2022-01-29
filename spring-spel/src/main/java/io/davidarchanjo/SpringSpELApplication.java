package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringSpELApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSpELApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> log.info("CommandLineRunner: {}", String.join(",", args));
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> log.info("ApplicationRunner: {}", String.join(",", args.getSourceArgs()));
    }
}