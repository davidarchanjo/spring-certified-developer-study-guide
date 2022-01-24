package io.davidarchanjo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {

	private int id;  
	private String name;  
	private float salary;  

	@Builder
	public Employee(int id, String name, float salary) {
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