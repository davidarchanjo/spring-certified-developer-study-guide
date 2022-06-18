package io.davidarchanjo.actuator.health.indicator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component("bookTable")
@RequiredArgsConstructor
public class BookTableHealthIndicator implements HealthIndicator {
    
    private final DataSource dataSource;

    @Override
    public Health health() {
        try (Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement()
        ) {
            stmt.execute("SELECT id, name FROM public.book");
            return Health.up().build();
        } catch (SQLException ex) {
            return Health.outOfService().withException(ex).build();
        }        
    }
}