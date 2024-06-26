package com.hampcode.bankingservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.bankingservice.model.dto.IngredientResponseDTO;
import com.hampcode.bankingservice.services.IngredientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ingredients")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class IngredientController {
    private final IngredientService ingredientService;
    @GetMapping
    public ResponseEntity<List<IngredientResponseDTO>> getAllIngredients(){
        List<IngredientResponseDTO>ingredients=ingredientService.getAllIngredients();
        return new ResponseEntity<>(ingredients,HttpStatus.OK);
    }
}
