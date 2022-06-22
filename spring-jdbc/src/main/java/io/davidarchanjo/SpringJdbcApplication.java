package io.davidarchanjo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Profile("!test")
	@Bean
	EasyRandom easyRandom() {
		var easyRandomParameters = new EasyRandomParameters();
		easyRandomParameters.randomize(Integer.class, () -> ThreadLocalRandom.current().nextInt(1, 100));
		return new EasyRandom(easyRandomParameters);
	}

	@Profile("!test")
	@Bean
	CommandLineRunner commandLineRunner(EmployeeDao dao, EasyRandom easyRandom) {
		return args -> {
			try {
				dao.createTable();

				var emp = easyRandom.nextObject(Employee.class);
				dao.saveEmployee(emp);
				log.info("Save: {}", dao.queryEmployee(emp.getId()));

				log.info("Query By Id: {}", dao.queryEmployee(emp.getId()));

				IntStream.rangeClosed(1, 5).forEach(o -> dao.saveEmployee(easyRandom.nextObject(Employee.class)));
				log.info("Query All: {}", dao.queryEmployees());
				// var res2 = dao.queryEmployees2(emp.getId());
				// var res3 = dao.queryEmployees3();

				log.info("Update Before: {}", dao.queryEmployee(emp.getId()));
				dao.updateEmployee(emp.toBuilder().name("David Archanjo").build());
				log.info("Update After: {}", dao.queryEmployee(emp.getId()));

				log.info("Delete Status: {}", dao.deleteEmployee(emp.getId()));
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
			}
		};
	}
}