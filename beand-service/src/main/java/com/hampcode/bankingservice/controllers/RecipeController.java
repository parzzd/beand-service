package com.hampcode.bankingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hampcode.bankingservice.model.entities.Recipe;
import com.hampcode.bankingservice.services.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Recipe>> getConsumableRecipesForUser(@PathVariable Long userId) {
        List<Recipe> recipes = recipeService.getConsumableRecipesForUser(userId);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
}
