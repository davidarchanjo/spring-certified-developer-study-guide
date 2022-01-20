package io.davidarchanjo.service;

import io.davidarchanjo.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee employee);
	void deleteEmployeeById(String empid);
}