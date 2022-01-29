package io.davidarchanjo.builder;

import io.davidarchanjo.model.domain.ToDo;
import io.davidarchanjo.model.dto.ToDoDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ToDoBuilder {

    private final ModelMapper modelMapper;

    public ToDo build(ToDoDTO dto) {
        return ToDo.builder()
            .id(dto.getId())
            .task(dto.getTask())
            .completed(dto.getCompleted())
            .build();
    }

    public ToDoDTO build(ToDo domain) {
        return ToDoDTO.builder()
            .id(domain.getId())
            .task(domain.getTask())
            .completed(domain.isCompleted())
            .build();
    }

    public ToDo build(ToDoDTO dto, ToDo domain) {
        modelMapper.map(dto, domain);
        return domain;
    }

}