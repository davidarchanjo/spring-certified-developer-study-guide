package io.davidarchanjo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

interface ToDoable {
}

@Component
class Foo implements ToDoable {
}

@Component
class Bar implements ToDoable {
}

@ToString
@AllArgsConstructor
public class ToDo {
    private ToDoable todoable;
}