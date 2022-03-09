package io.davidarchanjo;

import io.davidarchanjo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringTransaction2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringTransaction2Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductService productService) {
		return args -> {
			productService.createProduct1();
		};
	}

}
