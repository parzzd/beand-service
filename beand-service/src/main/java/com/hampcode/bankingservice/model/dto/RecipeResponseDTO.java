package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeResponseDTO {

    private String recipeName;
    private List<IngredientResponseDTO> ingredients;
    private String recipeDescription;
}