package io.davidarchanjo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import io.davidarchanjo.model.Employee;
import io.davidarchanjo.model.EmployeeHealthInsurance;
import io.davidarchanjo.service.EmployeeService;
import io.davidarchanjo.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);		
	}

	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {
			try {
				OrganizationService organizationService = context.getBean("organization-transactional-service", OrganizationService.class);

				EmployeeService employeeService = context.getBean(EmployeeService.class);

				Employee employee = Employee.builder()
					.empId("emp1")
					.empName("emp1")
					.build();

				EmployeeHealthInsurance employeeHealthInsurance = EmployeeHealthInsurance.builder()
					.empId("emp1")
					.healthInsuranceSchemeName("premium")
					.coverageAmount(20000)
					.build();

				organizationService.joinOrganization(employee, employeeHealthInsurance);

				employeeService.insertEmployee(employee);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
			}
		};
	}
}

// docker run --name spring-jdbc-postgres --rm -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e PGDATA=/var/lib/postgresql/data/pgdata -v /tmp:/var/lib/postgresql/data -p 5432:5432 -it postgres:14.1-alpine