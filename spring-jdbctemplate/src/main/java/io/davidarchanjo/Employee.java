package io.davidarchanjo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Employee {

	private int id;  
	private String name;  
	private BigDecimal salary;

	@Builder
	public Employee(int id, String name, BigDecimal salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public EmployeeBuilder toBuilder() {
		return Employee.builder()
			.id(this.id)
			.name(this.name)
			.salary(this.salary);
	}
}