package io.davidarchanjo.code;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBeansApplication {

    public static void main(String... args) {
        SpringApplication.run(SpringBeansApplication.class, args);
        // https://www.baeldung.com/spring-application-context
    }

    @Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			log.info("Let's list all the beans provided by Spring Boot:");
            Arrays.stream(ctx.getBeanDefinitionNames())
                .sorted()
                .forEach(System.out::println);
		};
	}

}
