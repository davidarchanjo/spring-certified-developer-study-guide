package io.davidarchanjo.database;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import io.davidarchanjo.repository.ToDoRepository;

@ActiveProfiles("test")
@DataJpaTest
public class ToDoRepositoryTest {

  @Autowired 
  private DataSource dataSource;

  @Autowired 
  private JdbcTemplate jdbcTemplate;

  @Autowired 
  private EntityManager entityManager;

  @Autowired 
  private ToDoRepository todoRepository;

  @Test
  void injectedComponentsAreNotNull() {
    assertThat(dataSource).isNotNull();
    assertThat(jdbcTemplate).isNotNull();
    assertThat(entityManager).isNotNull();
    assertThat(todoRepository).isNotNull();
  }
}