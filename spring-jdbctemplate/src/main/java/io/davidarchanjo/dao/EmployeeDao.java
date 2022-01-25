package io.davidarchanjo.dao;

import io.davidarchanjo.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	/**
	 * NOTE: We could have leveraged of the mechanism of script-based
	 * initialization (via schema.sql) to create the table
	 */
	public void createTable() {
		final String sql = "CREATE TABLE employee ( id NUMBER NOT NULL, name VARCHAR(100) NOT NULL, salary NUMBER NOT NULL);";
		jdbcTemplate.execute(sql);
	}

	public int saveEmployee(Employee emp) {
		final String sql = "INSERT INTO employee VALUES (?, ?, ?)";
		return jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getSalary());
	}

	public int updateEmployee(Employee emp) {
		final String sql = "UPDATE employee SET name = ?, salary = ? WHERE id = ?";
		return jdbcTemplate.update(sql, emp.getName(), emp.getSalary(), emp.getId());
	}

	public int deleteEmployee(long id) {
		final String sql = "DELETE FROM employee WHERE id = ?";
		return jdbcTemplate.update(sql, id);
	}

	public Employee queryEmployee(long id) {
		final String query = "SELECT * FROM employee WHERE id = ?";
		return jdbcTemplate.queryForObject(query, EmployeeRowMapper.builder().build(), id);
	}

	public List<Employee> queryEmployees() {
		final String query = "SELECT * FROM employee";
		return jdbcTemplate.query(query, EmployeeRowMapper.builder().build());
	}

}