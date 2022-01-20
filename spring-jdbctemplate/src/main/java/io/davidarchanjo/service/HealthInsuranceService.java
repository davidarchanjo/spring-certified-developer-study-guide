package io.davidarchanjo.service;

import io.davidarchanjo.model.EmployeeHealthInsurance;

public interface HealthInsuranceService {
	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);
	void deleteEmployeeHealthInsuranceById(String empid);
}