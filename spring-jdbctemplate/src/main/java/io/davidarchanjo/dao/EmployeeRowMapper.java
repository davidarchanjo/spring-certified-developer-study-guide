package io.davidarchanjo.dao;

import io.davidarchanjo.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Employee.builder()
            .id(rs.getInt("ID"))
            .name(rs.getString("NAME"))
            .salary(rs.getFloat("SALARY"))
            .build();
    }

}