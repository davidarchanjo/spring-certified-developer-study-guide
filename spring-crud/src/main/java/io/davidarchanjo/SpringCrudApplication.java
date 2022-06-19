package io.davidarchanjo;

import java.util.stream.IntStream;

import org.jeasy.random.EasyRandom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import io.davidarchanjo.model.dto.ToDoDTO;
import io.davidarchanjo.service.ToDoService;

@SpringBootApplication
public class SpringCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}	

	@Profile("!test")
	@Bean
	CommandLineRunner commandLineRunner(EasyRandom easyRandom, ToDoService toDoService) {
		return args -> {
			IntStream.rangeClosed(1, 5).forEach(o -> {
				final ToDoDTO dto = easyRandom.nextObject(ToDoDTO.class);
				toDoService.create(dto);
			});
		};
	}
}