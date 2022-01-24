package io.davidarchanjo;

import io.davidarchanjo.dao.EmployeeDao;
import io.davidarchanjo.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringJdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplateApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EmployeeDao dao) {
		return args -> {
			try {
				int status = dao.saveEmployee(Employee.builder()
					.id(1)
					.name("Foo")
					.salary(35000)
					.build());
				log.info("Save Status: {}", status);
				
				Employee emp = dao.queryEmployee(1);
				log.info("Query Status: {}", emp);
					
//				status = dao.updateEmployee(Employee.builder()
//					.id(1)
//					.name("Bar")
//					.salary(15000)
//					.build());
//				log.info("Update Status: {}", status);
//
//				status = dao.deleteEmployee(emp);
//				log.info("Delete Status: {}", status);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
			}
		};
	}
}
// docker run --name spring-jdbc-postgres --rm -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e PGDATA=/var/lib/postgresql/data/pgdata -v /tmp:/var/lib/postgresql/data -p 5432:5432 -it postgres:14.1-alpine