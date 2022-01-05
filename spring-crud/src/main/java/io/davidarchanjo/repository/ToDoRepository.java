package io.davidarchanjo.repository;

import io.davidarchanjo.model.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
