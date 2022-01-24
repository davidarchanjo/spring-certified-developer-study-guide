package io.davidarchanjo.dao;

import io.davidarchanjo.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static java.lang.String.format;

@Repository
@RequiredArgsConstructor
public class EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public int saveEmployee(Employee e) {
		final String query = "INSERT INTO employee VALUES (?, ?, ?)";
		return jdbcTemplate.update(query, e.getId(), e.getName(), e.getSalary());
	}

	public int updateEmployee(Employee e) {
		final String query = "UPDATE employee SET name = ?, salary = ? WHERE id = ?";
		return jdbcTemplate.update(query, e.getName(), e.getSalary(), e.getId());
	}

	public int deleteEmployee(Employee e) {
		final String query = "DELETE FROM employee WHERE id = ?";
		return jdbcTemplate.update(query, e.getId());
	}

	public Employee queryEmployee(long id) {
		final String query = "SELECT * FROM employee WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), id);
	}

}