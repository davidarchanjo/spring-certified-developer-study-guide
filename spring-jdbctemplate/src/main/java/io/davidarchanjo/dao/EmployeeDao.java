package io.davidarchanjo.dao;

import static java.lang.String.format;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.davidarchanjo.model.Employee;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public int saveEmployee(Employee e){  
		final String query=format("INSERT INTO employee VALUES ('%s','%s','%s')", e.getId(), e.getName(), e.getSalary());
		return jdbcTemplate.update(query);  
	}

	public int updateEmployee(Employee e){  
		String query = format("UPDATE employee SET name='%s',salary='%s' WHERE id=%d", e.getName(), e.getSalary(), e.getId());
		return jdbcTemplate.update(query);  
	}

	public int deleteEmployee(Employee e) {
		String query=format("DELETE FROM employee WHERE id=%d", e.getId());
		return jdbcTemplate.update(query);
	}

}