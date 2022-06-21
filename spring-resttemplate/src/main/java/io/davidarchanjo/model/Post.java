package io.davidarchanjo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long id;
    private Long userId;
    private String title;
    private String body;
}