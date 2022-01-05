package io.davidarchanjo.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    @Email
    @NotNull 
    private String username;
    
    @NotNull
    private String password;

}
