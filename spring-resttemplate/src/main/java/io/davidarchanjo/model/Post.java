package io.davidarchanjo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {

    private Long id;
    private Long userId;
    private String title;
    private String body;
}