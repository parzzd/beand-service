package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeResponseDTO {
    private String recipeName;
    private String description;
    private Set<IngredientResponseDTO> ingredients;
}
