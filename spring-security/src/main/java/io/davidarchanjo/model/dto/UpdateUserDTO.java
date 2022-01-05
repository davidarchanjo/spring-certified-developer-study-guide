package io.davidarchanjo.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Builder
public class UpdateUserDTO {

    @NotBlank
    private String fullName;
    private Set<String> authorities;

}
