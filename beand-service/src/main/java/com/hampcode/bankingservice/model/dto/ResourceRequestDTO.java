package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceRequestDTO {
    @NotBlank(message = "debe de tener un nombre")
    @Pattern(regexp = "[a-zA-Z]+")
    private String resourceName;

    @NotBlank(message = "debe de tener una descripcion")
    @Pattern(regexp = "[a-zA-Z]+")
    private String resourceDescription;
}
