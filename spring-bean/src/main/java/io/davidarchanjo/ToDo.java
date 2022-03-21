package io.davidarchanjo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

interface ToDoable {
}

@Component
class F0o implements ToDoable {
}

@Component
class B0r implements ToDoable {
}

@ToString
@AllArgsConstructor
public class ToDo {
    private ToDoable todoable;
}