package io.davidarchanjo.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import io.davidarchanjo.dao.EmployeeDao;
import io.davidarchanjo.model.Employee;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {
		
	private final DataSource dataSource;
	private final JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertEmployee(Employee emp) {
		String sql = "INSERT INTO employee (empId, empName) VALUES (?,?)";
		jdbcTemplate.update(sql, emp.getEmpId(), emp.getEmpName());
	}

	@Override
	public void deleteEmployeeById(String empid) {
		String sql = "DELETE FROM employee WHERE empId = ?";
		jdbcTemplate.update(sql, empid);

	}
}