package io.davidarchanjo.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class Application {

	@Value("0xFF")
	private Long value;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}	

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			log.info("{}", value);
		};
	}
}