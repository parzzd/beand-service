package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeRequestDTO {
    @NotBlank(message = "La receta debe tener un nombre")
    @Pattern(regexp = "[a-zA-Z\s]+")
    private String recipeName;
    @NotBlank(message = "La receta debe tener una descripcion")
    @Pattern(regexp = "[a-zA-Z\s]+")
    private String description;
    private Set<String> ingredients;
}
