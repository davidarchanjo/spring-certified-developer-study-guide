package io.davidarchanjo.service.impl;

import io.davidarchanjo.builder.ToDoBuilder;
import io.davidarchanjo.model.dto.ToDoDTO;
import io.davidarchanjo.repository.ToDoRepository;
import io.davidarchanjo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private final ToDoBuilder builder;
    private final ToDoRepository repository;

    @Override
    public ToDoDTO create(ToDoDTO dto) {
        return Optional.of(dto)
            .map(builder::build)
            .map(repository::save)
            .map(builder::build)
            .orElseThrow(() -> new PersistenceException("Failed to create entity - " + dto));
    }

    @Override
    public List<ToDoDTO> findAll() {
        return repository.findAll()
            .stream()
            .map(builder::build)
            .collect(Collectors.toList());
    }

    @Override
    public ToDoDTO findById(Long id) {
        return repository.findById(id)
                .map(builder::build)
                .orElseThrow(() -> new EntityNotFoundException("No such entity for id " + id));
    }

    @Override
    public ToDoDTO findByTask(String task) {
        return repository.findByTask(task)
            .map(builder::build)
            .orElseThrow(() -> new EntityNotFoundException("No such entity for task " + task));
    }

    @Override
    public void update(Long id, ToDoDTO dto) {
        repository.findById(id)
            .map(domain -> builder.build(dto, domain))
            .map(repository::save)            
            .orElseThrow(() -> new EntityNotFoundException("No such entity for id " + id));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
        .ifPresentOrElse(
            repository::delete,
            () -> { throw new EntityNotFoundException("No such entity for id " + id);});
    }

}