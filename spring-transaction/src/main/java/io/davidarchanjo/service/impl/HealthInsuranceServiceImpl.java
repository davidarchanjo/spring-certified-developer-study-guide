package io.davidarchanjo.service.impl;

import org.springframework.stereotype.Service;

import io.davidarchanjo.dao.HealthInsuranceDao;
import io.davidarchanjo.model.EmployeeHealthInsurance;
import io.davidarchanjo.service.HealthInsuranceService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HealthInsuranceServiceImpl implements HealthInsuranceService {
	
	private final HealthInsuranceDao healthInsuranceDao;

	@Override
	public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) {
		healthInsuranceDao.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	public void deleteEmployeeHealthInsuranceById(String empId) {
		healthInsuranceDao.deleteEmployeeHealthInsuranceById(empId);
	}

}