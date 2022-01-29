package io.davidarchanjo.repository;

import io.davidarchanjo.model.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    Optional<ToDo> findByTask(String task);
}
