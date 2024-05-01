package com.hampcode.bankingservice.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.bankingservice.model.entities.Recipe;
import com.hampcode.bankingservice.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getConsumableRecipesForUser(Long userId) {
        return recipeRepository.findConsumableRecipesForUser(userId);
    }
}
