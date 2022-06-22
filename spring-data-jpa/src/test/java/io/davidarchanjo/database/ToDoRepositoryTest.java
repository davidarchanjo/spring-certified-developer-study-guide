package io.davidarchanjo.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.davidarchanjo.model.domain.ToDo;
import io.davidarchanjo.repository.ToDoRepository;

@DataJpaTest
class ToDoRepositoryTest {

    @Autowired
    private ToDoRepository todoRepository;

    @Test
    void save() {
        ToDo todo = ToDo.builder()
            .task("Study For Certification")
            .completed(false)
            .build();
        todoRepository.save(todo);

        Optional<ToDo> $todo = todoRepository.findByTask(todo.getTask());
        assertNotNull($todo);
        assertEquals(todo, $todo.get());
    }

}
