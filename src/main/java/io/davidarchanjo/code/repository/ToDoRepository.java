package io.davidarchanjo.code.repository;

import io.davidarchanjo.code.model.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
