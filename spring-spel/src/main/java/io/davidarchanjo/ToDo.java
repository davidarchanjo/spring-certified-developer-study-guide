package io.davidarchanjo;

import lombok.Builder;
import lombok.Data;

@Data
public class ToDo {
    private String task;
    private boolean completed;

    @Builder
    public ToDo(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public static String getHello() {
		return "david";
	}
}