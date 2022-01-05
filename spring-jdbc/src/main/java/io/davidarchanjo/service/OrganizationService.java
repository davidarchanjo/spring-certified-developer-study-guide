package io.davidarchanjo.service;

import io.davidarchanjo.model.Employee;
import io.davidarchanjo.model.EmployeeHealthInsurance;

public interface OrganizationService {
	void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
	void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
}