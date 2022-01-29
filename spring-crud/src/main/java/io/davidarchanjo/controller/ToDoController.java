package io.davidarchanjo.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import io.davidarchanjo.model.dto.ToDoDTO;
import io.davidarchanjo.service.ToDoService;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/todos")
public class ToDoController {

    private final ToDoService service;
    
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ToDoDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        final ToDoDTO todo = service.create(dto);
        final UriComponents uriComponents = uriComponentsBuilder
            .path("/api/todos/{id}")
            .buildAndExpand(todo.getId());
        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> find(@RequestParam(required = false) String task) {
        return Objects.isNull(task)
            ? ResponseEntity.ok(service.findAll())
            : ResponseEntity.ok(service.findByTask(task));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ToDoDTO dto) {
        service.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
