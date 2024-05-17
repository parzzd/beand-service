package com.hampcode.bankingservice.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

import com.hampcode.bankingservice.model.dto.IngredientResponseDTO;
import com.hampcode.bankingservice.model.dto.RecipeRequestDTO;
import com.hampcode.bankingservice.model.dto.RecipeResponseDTO;
import com.hampcode.bankingservice.model.entities.Recipe;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RecipeMapper {
    private final ModelMapper modelMapper;
    public Recipe convertToEntity(RecipeRequestDTO recipeRequestDTO){
        return modelMapper.map(recipeRequestDTO, Recipe.class);
    }
    public RecipeResponseDTO convertToRecipeDTO(Recipe recipe){
        return modelMapper.map(recipe, RecipeResponseDTO.class);
    }
    public List<RecipeResponseDTO> convertToListRecipeDTO(List<Recipe> recipes){
        return recipes.stream().map(this::convertToRecipeDTO).toList();
    }

    public RecipeResponseDTO convertToRecipeDTOO(Recipe recipe) {
        RecipeResponseDTO dto = new RecipeResponseDTO();
        dto.setRecipeName(recipe.getRecipeName());
        dto.setDescription(recipe.getDescription());

        Set<IngredientResponseDTO> ingredientDTOs = recipe.getIngredients().stream()
            .map(ingredient -> {
                IngredientResponseDTO ingredientDTO = new IngredientResponseDTO();
                ingredientDTO.setId(ingredient.getId());
                ingredientDTO.setIngredientName(ingredient.getIngredientName());
                return ingredientDTO;
            })
            .collect(Collectors.toSet());
        
        dto.setIngredients(ingredientDTOs);

        return dto;
    }


}
