package io.davidarchanjo.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import io.davidarchanjo.dao.HealthInsuranceDao;
import io.davidarchanjo.model.EmployeeHealthInsurance;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HealthInsuranceDaoImpl extends JdbcDaoSupport implements HealthInsuranceDao {
	
	private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void registerEmployeeHealthInsurance(EmployeeHealthInsurance emp) {
		String sql = "INSERT INTO employeeHealthInsurance (empId, healthInsuranceSchemeName, coverageAmount) VALUES (?,?,?)";
		jdbcTemplate.update(sql, emp.getEmpId(), emp.getHealthInsuranceSchemeName(), emp.getCoverageAmount());
	}

	@Override
	public void deleteEmployeeHealthInsuranceById(String empid) {
		String sql = "DELETE FROM employeeHealthInsurance WHERE empId = ?";
		jdbcTemplate.update(sql, empid);
	}
}