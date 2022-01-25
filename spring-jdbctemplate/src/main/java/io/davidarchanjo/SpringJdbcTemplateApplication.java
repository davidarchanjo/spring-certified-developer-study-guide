package io.davidarchanjo;

import io.davidarchanjo.dao.EmployeeDao;
import io.davidarchanjo.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
@SpringBootApplication
public class SpringJdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplateApplication.class, args);
	}

	@Bean
	EasyRandom easyRandom() {
		EasyRandomParameters parameters = new EasyRandomParameters();
		parameters.randomize(Integer.class, () -> ThreadLocalRandom.current().nextInt(1, 100));
		return new EasyRandom(parameters);
	}

	@Bean
	CommandLineRunner commandLineRunner(EmployeeDao dao, EasyRandom easyRandom) {
		return args -> {
			try {
				dao.createTable();

				final Employee emp = easyRandom.nextObject(Employee.class);
				dao.saveEmployee(emp);
				log.info("Save: {}", dao.queryEmployee(emp.getId()));

				log.info("Query By Id: {}", dao.queryEmployee(emp.getId()));

				IntStream.rangeClosed(1, 5).forEach(o -> dao.saveEmployee(easyRandom.nextObject(Employee.class)));
				log.info("Query All: {}", dao.queryEmployees());

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
// docker run --name spring-jdbc-postgres --rm -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e PGDATA=/var/lib/postgresql/data/pgdata -v /tmp:/var/lib/postgresql/data -p 5432:5432 -it postgres:14.1-alpine