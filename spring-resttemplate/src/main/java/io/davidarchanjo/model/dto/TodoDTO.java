package io.davidarchanjo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoDTO {
	private Long id;
	private String task;
	private Boolean completed;
}