package io.davidarchanjo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> log.info("running from CommandLineRunner");
	}	
	
	@Bean
	ApplicationRunner applicationRunner2() {
		return args -> log.info("running from applicationRunner2");
	}
	
	@Bean
	ApplicationRunner applicationRunner1() {
		return args -> log.info("running from applicationRunner1");
	}

}