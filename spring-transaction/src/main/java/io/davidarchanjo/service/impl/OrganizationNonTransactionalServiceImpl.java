package io.davidarchanjo.service.impl;

import io.davidarchanjo.model.Employee;
import io.davidarchanjo.model.EmployeeHealthInsurance;
import io.davidarchanjo.service.EmployeeService;
import io.davidarchanjo.service.HealthInsuranceService;
import io.davidarchanjo.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("organization-non-transactional-service")
public class OrganizationNonTransactionalServiceImpl implements OrganizationService {

	private final EmployeeService employeeService;	
	private final HealthInsuranceService healthInsuranceService;

	@Override
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.insertEmployee(employee);
        if (employee.getEmpId().equals("emp1")) {
			throw new RuntimeException("thowing exception to test transaction rollback");
		}
		healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.deleteEmployeeById(employee.getEmpId());
		healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
	}
}