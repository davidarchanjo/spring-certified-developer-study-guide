package io.davidarchanjo;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestTemplateApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
			.setConnectTimeout(Duration.ofMillis(30000))
			.setReadTimeout(Duration.ofMillis(30000))
			.build();
	}
}