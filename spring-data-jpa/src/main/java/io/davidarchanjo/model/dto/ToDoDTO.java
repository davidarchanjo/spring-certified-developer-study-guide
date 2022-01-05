package io.davidarchanjo.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
@JsonPropertyOrder({"id", "task", "completed"})
public class ToDoDTO {

    private Long id;

    @NotNull(message = "Attribute 'task' must not be null")
    private String task;

    @NotNull(message = "Attribute 'completed' must not be null")
    private Boolean completed;
    
    public ToDoDTOBuilder toBuilder() {
        return ToDoDTO.builder()
            .id(this.getId())
            .task(this.getTask())
            .completed(this.getCompleted());
    }

}