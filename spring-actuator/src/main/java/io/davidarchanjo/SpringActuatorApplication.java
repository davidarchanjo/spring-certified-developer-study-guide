package io.davidarchanjo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringActuatorApplication {

    public static void main(String... args) {
        SpringApplication.run(SpringActuatorApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {
            DataSourceHealthIndicator d;
            repository.save(new Book(null, "Java"));
            repository.save(new Book(null, "Node"));
            repository.save(new Book(null, "Python"));

            log.info("findAll()");
            repository.findAll().forEach(x -> log.info("{}", x));

            log.info("findById(1L)");
            repository.findById(1l).ifPresent(x -> log.info("{}", x));

            log.info("findByName('Node')");
            repository.findByName("Node").forEach(x -> log.info("{}", x));
        };
    }

}
