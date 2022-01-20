package io.davidarchanjo.dao;

import io.davidarchanjo.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee employee);	
	void deleteEmployeeById(String empid);
}