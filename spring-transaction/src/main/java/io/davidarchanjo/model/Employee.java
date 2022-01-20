package io.davidarchanjo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
	private String empId;
	private String empName;	

	@Builder
	public Employee(String empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}
}