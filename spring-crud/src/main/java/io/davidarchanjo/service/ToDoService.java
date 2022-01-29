package io.davidarchanjo.service;

import io.davidarchanjo.model.dto.ToDoDTO;

import java.util.List;

public interface ToDoService {

    ToDoDTO create(ToDoDTO dto);
    List<ToDoDTO> findAll();
    ToDoDTO findById(Long id);
    ToDoDTO findByTask(String task);
    void update(Long id, ToDoDTO dto);
    void delete(Long id);

}