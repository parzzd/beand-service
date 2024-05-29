package com.hampcode.bankingservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hampcode.bankingservice.mapper.RecipeMapper;
import com.hampcode.bankingservice.model.dto.RecipeRequestDTO;
import com.hampcode.bankingservice.model.dto.RecipeResponseDTO;
import com.hampcode.bankingservice.model.entities.Ingredient;
import com.hampcode.bankingservice.model.entities.Recipe;
import com.hampcode.bankingservice.repository.IngredientRepository;
import com.hampcode.bankingservice.repository.RecipeRepository;

@SpringBootTest
class RecipeServiceApplicationTest {
	@Mock
	IngredientRepository ingredientRepository;
	@Mock
	RecipeRepository recipeRepository;
	@Mock
	RecipeMapper recipeMapper;
	@InjectMocks
	private RecipeService recipeService;

	@Test
    public void testFindRecipeByRecipeName() {
        // Arrange
        String recipeName = "lomo saltado";
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeName);
        recipe.setDescription("platillo a base de arroz, tomate, cebolla y lomo");

        RecipeResponseDTO recipeResponseDTO = new RecipeResponseDTO();
        recipeResponseDTO.setRecipeName(recipeName);
        recipeResponseDTO.setDescription("platillo a base de arroz, tomate, cebolla y lomo");

        // Mocking repository
        when(recipeRepository.findByRecipeName(recipeName)).thenReturn(recipe);

        // Mocking mapper
        when(recipeMapper.convertToRecipeDTO(recipe)).thenReturn(recipeResponseDTO);

        // Act
        RecipeResponseDTO foundRecipeDTO = recipeService.getByRecipeName(recipeName);

        // Assert
        assertNotNull(foundRecipeDTO);
        assertEquals(recipeName, foundRecipeDTO.getRecipeName());
        assertEquals("platillo a base de arroz, tomate, cebolla y lomo", foundRecipeDTO.getDescription());

        // Verify that repository and mapper methods were called
        verify(recipeRepository, times(1)).findByRecipeName(recipeName);
        verify(recipeMapper, times(1)).convertToRecipeDTO(recipe);
    }
	//userstory 11
	@Test
    public void testCreateRecipeResponseDTO() {
        RecipeRequestDTO recipeRequestDTO = new RecipeRequestDTO();
        recipeRequestDTO.setRecipeName("Lomo Saltado");
        recipeRequestDTO.setDescription("Comida a base de arroz y carne con tomate y cebolla");

        Set<String> ingredients = new HashSet<>();
        ingredients.add("tomate");
        ingredients.add("cebolla");
        recipeRequestDTO.setIngredients(ingredients);

        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeRequestDTO.getRecipeName());
        recipe.setDescription(recipeRequestDTO.getDescription());

        Ingredient tomate = new Ingredient();
        tomate.setIngredientName("tomate");

        Ingredient cebolla = new Ingredient();
        cebolla.setIngredientName("cebolla");

        when(ingredientRepository.findByIngredientName("tomate")).thenReturn(null);
        when(ingredientRepository.save(any(Ingredient.class))).thenReturn(tomate);
        when(ingredientRepository.findByIngredientName("cebolla")).thenReturn(cebolla);

        when(recipeRepository.save(any(Recipe.class))).thenReturn(recipe);

        RecipeResponseDTO recipeResponseDTO = new RecipeResponseDTO();
        recipeResponseDTO.setRecipeName(recipeRequestDTO.getRecipeName());
        recipeResponseDTO.setDescription(recipeRequestDTO.getDescription());

        when(recipeMapper.convertToRecipeDTO(any(Recipe.class))).thenReturn(recipeResponseDTO);

        RecipeResponseDTO createdRecipeResponseDTO = recipeService.createRecipeResponseDTO(recipeRequestDTO);

        assertNotNull(createdRecipeResponseDTO);
        assertEquals(recipeRequestDTO.getRecipeName(), createdRecipeResponseDTO.getRecipeName());
        assertEquals(recipeRequestDTO.getDescription(), createdRecipeResponseDTO.getDescription());

        verify(ingredientRepository, times(1)).findByIngredientName("tomate");
        verify(ingredientRepository, times(1)).save(any(Ingredient.class));
        verify(ingredientRepository, times(1)).findByIngredientName("cebolla");
        verify(recipeRepository, times(1)).save(any(Recipe.class));
        verify(recipeMapper, times(1)).convertToRecipeDTO(any(Recipe.class));
    }
	//user story 12
    @Test
    public void testChangeByRecipeName() {
        // Arrange
        RecipeRequestDTO recipeRequestDTO = new RecipeRequestDTO();
        recipeRequestDTO.setRecipeName("Lomo Saltado");
        recipeRequestDTO.setDescription("Nueva descripción");

        Set<String> ingredientsToRemove = new HashSet<>();
        ingredientsToRemove.add("tomate");
        ingredientsToRemove.add("cebolla");
        recipeRequestDTO.setIngredients(ingredientsToRemove);

        Recipe originalRecipe = new Recipe();
        originalRecipe.setRecipeName("Lomo Saltado");
        originalRecipe.setDescription("Descripción original");

        Ingredient tomate = new Ingredient();
        tomate.setId(1L);
        tomate.setIngredientName("tomate");

        Ingredient cebolla = new Ingredient();
        cebolla.setId(2L);
        cebolla.setIngredientName("cebolla");

        originalRecipe.addIngredient(tomate);
        originalRecipe.addIngredient(cebolla);

        // Mocking repositories
        when(recipeRepository.findByRecipeName("Lomo Saltado")).thenReturn(originalRecipe);
        when(ingredientRepository.findByIngredientName("tomate")).thenReturn(tomate);
        when(ingredientRepository.findByIngredientName("cebolla")).thenReturn(cebolla);

        Recipe newRecipe = new Recipe();
        newRecipe.setId(2L);
        newRecipe.setRecipeName("Lomo Saltado2");
        newRecipe.setDescription("Nueva descripción");
        newRecipe.addIngredient(cebolla); // Ingredient "tomate" is removed

        when(recipeRepository.save(any(Recipe.class))).thenReturn(newRecipe);

        // Mocking mapper
        RecipeResponseDTO recipeResponseDTO = new RecipeResponseDTO();
        recipeResponseDTO.setRecipeName("Lomo Saltado2");
        recipeResponseDTO.setDescription("Nueva descripción");

        when(recipeMapper.convertToRecipeDTO(any(Recipe.class))).thenReturn(recipeResponseDTO);

        // Act
        RecipeResponseDTO result = recipeService.changeByRecipeName(recipeRequestDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Lomo Saltado2", result.getRecipeName());
        assertEquals("Nueva descripción", result.getDescription());

        // Verify interactions
        verify(recipeRepository, times(1)).findByRecipeName("Lomo Saltado");
        verify(ingredientRepository, times(1)).findByIngredientName("tomate");
        verify(ingredientRepository, times(1)).findByIngredientName("cebolla");
        verify(recipeRepository, times(1)).save(any(Recipe.class));
        verify(recipeMapper, times(1)).convertToRecipeDTO(any(Recipe.class));
    }


}
