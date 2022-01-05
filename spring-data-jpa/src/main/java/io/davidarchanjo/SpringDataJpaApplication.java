package io.davidarchanjo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Order(2000)
	@Bean
	ApplicationRunner init() {
		return args -> {
			log.info("running from Application Runner");
		};
	}

	@Order(1000)
	@Bean
	ApplicationRunner init2() {
		return args -> {
			log.info("running from CommandLineRunner");
		};
	}

}