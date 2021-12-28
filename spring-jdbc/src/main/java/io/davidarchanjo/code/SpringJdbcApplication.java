package io.davidarchanjo.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringJdbcApplication {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String args[]) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}	

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			log.info("Creating tables::");
			jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
			jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

			log.info("Processing data to persist::");
			List<Object[]> splitUpNames = List.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
				.map(name -> name.split(" "))
				.collect(Collectors.toList());
			splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

			log.info("Bulking data insert operation::");
			jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

			log.info("Querying for customer records where first_name = 'Josh'::");
			jdbcTemplate.query(
				"SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[]{"Josh"},
				(rs, rowNum) -> Customer.builder()
					.id(rs.getLong("id"))
					.firstName(rs.getString("first_name"))
					.lastName(rs.getString("last_name"))
					.build())
				.forEach(customer -> log.info(customer.toString()));
		};
	}
}
