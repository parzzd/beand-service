package com.hampcode.bankingservice.controller;



import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hampcode.bankingservice.controllers.RecipeController;
import com.hampcode.bankingservice.model.dto.RecipeRequestDTO;
import com.hampcode.bankingservice.model.dto.RecipeResponseDTO;
import com.hampcode.bankingservice.services.RecipeService;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    RecipeService recipeService;
    @InjectMocks
    private RecipeController recipeController;
    //user story 11
    @Test
    public void testCreateRecipe()throws Exception{
        RecipeRequestDTO recipeRequestDTO=new RecipeRequestDTO();
        //configurar datos de solititud
        recipeRequestDTO.setRecipeName("Lomo Saltado");
        recipeRequestDTO.setDescription("Comida a base de arroz y carne con tomate y cebolla");
        Set<String> ingredients = new HashSet<>();
        ingredients.add("tomate");
        ingredients.add("cebolla");
        recipeRequestDTO.setIngredients(ingredients);

        mockMvc.perform(MockMvcRequestBuilders.post("/recipes").contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(recipeRequestDTO))).andExpect(MockMvcResultMatchers.status().isCreated());
    }
    //user story 12
    //corregir probablemente
    @Test
    public void testChangeByRecipeName() throws Exception {
        RecipeRequestDTO recipeRequestDTO = new RecipeRequestDTO();
        recipeRequestDTO.setRecipeName("Lomo Saltado");
        recipeRequestDTO.setDescription("Comida a base de arroz y carne con tomate y cebolla");
        Set<String> ingredients = new HashSet<>();
        ingredients.add("tomate");
        ingredients.add("cebolla");
        recipeRequestDTO.setIngredients(ingredients);

        RecipeResponseDTO responseDTO = new RecipeResponseDTO();
        responseDTO.setRecipeName("Lomo Saltado 2");
        responseDTO.setDescription("Comida a base de arroz y carne con tomate y cebolla");

        when(recipeService.changeByRecipeName(recipeRequestDTO)).thenReturn(responseDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/recipes/cambiar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(recipeRequestDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }




    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
