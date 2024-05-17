package com.hampcode.bankingservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hampcode.bankingservice.mapper.IngredientMapper;
import com.hampcode.bankingservice.model.dto.IngredientResponseDTO;
import com.hampcode.bankingservice.model.entities.Ingredient;
import com.hampcode.bankingservice.repository.IngredientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IngredientService {
    private final IngredientMapper ingredientMapper;
    private final IngredientRepository ingredientRepository;

    public List<IngredientResponseDTO> getAllIngredients(){
        List<Ingredient> ingredients= ingredientRepository.findAll();
        return ingredientMapper.convertToIngredientListDTO(ingredients);
    } 

}