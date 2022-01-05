package io.davidarchanjo.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String fullName;

}
