package io.davidarchanjo.code.service;

import io.davidarchanjo.code.model.dto.ToDoDTO;

import java.util.List;

public interface ToDoService {

    ToDoDTO create(ToDoDTO dto);
    List<ToDoDTO> findAll();
    ToDoDTO findById(Long id);
    void update(Long id, ToDoDTO dto);
    void delete(Long id);

}