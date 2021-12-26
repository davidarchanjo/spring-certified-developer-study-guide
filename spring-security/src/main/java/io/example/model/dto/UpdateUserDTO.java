package io.example.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class UpdateUserDTO {

    @NotBlank
    private String fullName;
    private Set<String> authorities;

}
