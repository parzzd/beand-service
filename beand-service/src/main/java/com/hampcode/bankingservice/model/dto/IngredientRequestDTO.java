package com.hampcode.bankingservice.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientRequestDTO {
    @NotBlank(message = "debe tener un nombre el ingrediente")
    @Pattern(regexp = "[a-zA-Z]+")
    private String ingredientName;
}

