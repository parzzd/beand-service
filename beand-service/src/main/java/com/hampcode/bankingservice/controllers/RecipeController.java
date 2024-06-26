package com.hampcode.bankingservice.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.bankingservice.model.dto.RecipeRequestDTO;
import com.hampcode.bankingservice.model.dto.RecipeResponseDTO;
import com.hampcode.bankingservice.services.RecipeService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/recipes")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {
    private final RecipeService recipeService; 

    @GetMapping
    public ResponseEntity<List<RecipeResponseDTO>> getAllRecipes(){
        List<RecipeResponseDTO>recipes=recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes,HttpStatus.OK);
    }
    @GetMapping("/nombre/{recipeName}")
    public ResponseEntity<RecipeResponseDTO> getByRecipeName(@PathVariable String recipeName){
        RecipeResponseDTO recipes=recipeService.getByRecipeName(recipeName);
        return new ResponseEntity<>(recipes,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RecipeResponseDTO> createRecipe(@RequestBody @Validated RecipeRequestDTO recipeRequestDTO){
        RecipeResponseDTO createrecipe=recipeService.createRecipeResponseDTO(recipeRequestDTO);
        return new ResponseEntity<>(createrecipe,HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<RecipeResponseDTO>> getByUserID(@PathVariable Long userId) {
        List<RecipeResponseDTO> recipes = recipeService.getByUserID(userId);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
    @PostMapping("/cambiar")
    public ResponseEntity<RecipeResponseDTO> changeByRecipeName(@RequestBody @Validated RecipeRequestDTO recipeRequestDTO){
        RecipeResponseDTO newRecipe=recipeService.changeByRecipeName(recipeRequestDTO);
        return new ResponseEntity<>(newRecipe,HttpStatus.CREATED);
    }

}
