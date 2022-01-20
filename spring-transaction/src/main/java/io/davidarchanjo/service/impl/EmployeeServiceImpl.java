package io.davidarchanjo.service.impl;

import org.springframework.stereotype.Service;

import io.davidarchanjo.dao.EmployeeDao;
import io.davidarchanjo.model.Employee;
import io.davidarchanjo.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void deleteEmployeeById(String empid) {
		employeeDao.deleteEmployeeById(empid);
	}

}