package io.davidarchanjo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Transactional(propagation = Propagation.MANDATORY)
public class EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	/**
	 * NOTE: We could have leveraged on the mechanism of script-based
	 * initialization (via schema.sql) to create the table
	 */
	public void createTable() {
		final String sql = "CREATE TABLE employee ( id NUMBER NOT NULL, name VARCHAR(100) NOT NULL, salary NUMBER NOT NULL);";
		jdbcTemplate.execute(sql);
	}

	public void saveEmployee(Employee emp) {
		final String sql = "INSERT INTO employee VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getSalary());
		throw new RuntimeException();
	}

	public void updateEmployee(Employee emp) {
		final String sql = "UPDATE employee SET name = ?, salary = ? WHERE id = ?";
		jdbcTemplate.update(sql, emp.getName(), emp.getSalary(), emp.getId());
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

	public Map<String, Object> queryEmployees2(int id) {
		final String query = "SELECT DISTINCT * FROM employee WHERE id = ?";
		return jdbcTemplate.queryForMap(query, id);
	}

	public List<Employee> queryEmployees3() {
		final String sql = "SELECT * FROM employee";
		List<Employee> employees = new ArrayList<>();
		jdbcTemplate.queryForList(sql).forEach(row -> {
			final Employee emp = Employee.builder()
					.id(((BigDecimal) row.get("ID")).intValue())
					.name((String) row.get("NAME"))
					.salary((BigDecimal) row.get("SALARY"))
					.build();
			employees.add(emp);
		});
		return employees;
	}

}