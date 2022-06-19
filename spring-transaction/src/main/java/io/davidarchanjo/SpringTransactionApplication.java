package io.davidarchanjo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.davidarchanjo.service.ProductService;

@SpringBootApplication
public class SpringTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactionApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductService productService) {
		return args -> productService.createProduct1();
	}

}
