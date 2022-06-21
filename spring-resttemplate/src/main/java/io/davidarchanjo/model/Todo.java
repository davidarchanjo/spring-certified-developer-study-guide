package io.davidarchanjo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Todo {
	private Long id;
	private String task;
	private Boolean completed;
}
