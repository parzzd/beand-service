package com.hampcode.bankingservice.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.hampcode.bankingservice.model.dto.IngredientRequestDTO;
import com.hampcode.bankingservice.model.dto.IngredientResponseDTO;
import com.hampcode.bankingservice.model.entities.Ingredient;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class IngredientMapper{

    private final ModelMapper modelMapper;
    
    public Ingredient convertToEntity(IngredientRequestDTO ingredientRequestDTO){
        return modelMapper.map(ingredientRequestDTO, Ingredient.class);
    }
    public IngredientResponseDTO convertToIngredientDTO(Ingredient ingredient){
        return modelMapper.map(ingredient, IngredientResponseDTO.class);
    }
    public List<IngredientResponseDTO> convertToIngredientListDTO(List<Ingredient> ingredients){
        return ingredients.stream().map(this::convertToIngredientDTO).toList();
    }
   
}
