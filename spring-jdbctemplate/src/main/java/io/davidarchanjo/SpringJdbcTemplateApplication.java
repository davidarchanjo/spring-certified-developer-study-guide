package io.davidarchanjo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.davidarchanjo.dao.EmployeeDao;
import io.davidarchanjo.model.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringJdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplateApplication.class, args);		
	}

	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext context, EmployeeDao dao) {
		return args -> {
			try {
				// EmployeeDao dao = context.getBean(EmployeeDao.class);

				Employee emp = Employee.builder()
					.id(102)
					.name("Amit")
					.salary(35000)
					.build();

				int status = dao.saveEmployee(emp);  
				log.info("{}", status);  
					
				// int status=dao.updateEmployee(new Employee(102,"Sonoo",15000)); 
				// log.info("{}", status);
					
				// Employee e=new Employee();
				// e.setId(102);
				// int status=dao.deleteEmployee(e);
				// log.info("{}", status);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
			}
		};
	}
}

@RestController
class Hello {

    @RequestMapping("/")
    String index() {
        return "Hello world";
    }
}

// docker run --name spring-jdbc-postgres --rm -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e PGDATA=/var/lib/postgresql/data/pgdata -v /tmp:/var/lib/postgresql/data -p 5432:5432 -it postgres:14.1-alpine