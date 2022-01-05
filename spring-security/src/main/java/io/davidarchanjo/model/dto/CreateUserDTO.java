package io.davidarchanjo.model.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDTO {

    @Email
    @NotBlank 
    private String username;

    @NotBlank
    private String fullName;

    @NotBlank
    private String password;
    
    private List<String> authorities;

}
