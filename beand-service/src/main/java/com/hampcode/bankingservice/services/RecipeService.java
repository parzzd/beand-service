package com.hampcode.bankingservice.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hampcode.bankingservice.mapper.RecipeMapper;
import com.hampcode.bankingservice.model.dto.RecipeRequestDTO;
import com.hampcode.bankingservice.model.dto.RecipeResponseDTO;
import com.hampcode.bankingservice.model.entities.Ingredient;
import com.hampcode.bankingservice.model.entities.Recipe;
import com.hampcode.bankingservice.repository.IngredientRepository;
import com.hampcode.bankingservice.repository.RecipeRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeService {
    private final RecipeMapper recipeMapper;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public List<RecipeResponseDTO>getAllRecipes(){
        List<Recipe> recipes=recipeRepository.findAll();
        return recipeMapper.convertToListRecipeDTO(recipes);
    }

    public RecipeResponseDTO getByRecipeName(String recipeName){
        Recipe recipe=recipeRepository.findByRecipeName(recipeName);
        return recipeMapper.convertToRecipeDTO(recipe);
    }


    //probable error
    @Transactional
    public RecipeResponseDTO createRecipeResponseDTO(RecipeRequestDTO recipeRequestDTO) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeRequestDTO.getRecipeName());
        recipe.setDescription(recipeRequestDTO.getDescription());

        for (String ingredientName : recipeRequestDTO.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findByIngredientName(ingredientName);
            if (ingredient == null) {
                ingredient = new Ingredient();
                ingredient.setIngredientName(ingredientName);
                ingredient = ingredientRepository.save(ingredient);
            }
            recipe.addIngredient(ingredient);
        }

        // Save the recipe along with its ingredients
        recipe = recipeRepository.save(recipe);

        return recipeMapper.convertToRecipeDTO(recipe);
    }
}


