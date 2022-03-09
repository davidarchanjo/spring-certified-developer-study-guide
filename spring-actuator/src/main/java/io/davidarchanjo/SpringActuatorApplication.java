package io.davidarchanjo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringActuatorApplication {

    public static void main(String... args) {
        SpringApplication.run(SpringActuatorApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book(null, "Java"));
            bookRepository.save(new Book(null, "Node"));
            bookRepository.save(new Book(null, "Python"));
            bookRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @Bean
    Counter createdBooksCounter(MeterRegistry registry) {
        return Counter
            .builder("api.books.created")
            .description("Amount of books created")
            .register(registry);
    }

    @Bean
    Gauge createdBooksGauge(MeterRegistry registry, BookRepository bookRepository) {
        return Gauge
            .builder("api.books.count", bookRepository::count)
            .description("Amount of existing books")
            .register(registry);
    }

}
