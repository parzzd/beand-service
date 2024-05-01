package com.hampcode.bankingservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.bankingservice.model.dto.AccountRequestDTO;
import com.hampcode.bankingservice.model.dto.AccountResponseDTO;
import com.hampcode.bankingservice.model.dto.NutritionistRequestDTO;
import com.hampcode.bankingservice.model.dto.NutritionistResponseDTO;
import com.hampcode.bankingservice.services.NutritionistService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/nutritionists")
@AllArgsConstructor

public class NutritionistController {
    private final NutritionistService nutritionistService;

    @GetMapping
    public ResponseEntity<List<NutritionistResponseDTO>> getAllNutritionist(){
        List<NutritionistResponseDTO> nutritionists =nutritionistService.getAllNutritionist();
        return new ResponseEntity<>(nutritionists,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutritionistResponseDTO> getNutritionistById(@PathVariable Long id){
        NutritionistResponseDTO nutritionist = nutritionistService.getNutritionistById(id);
        return new ResponseEntity<>(nutritionist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NutritionistResponseDTO> createNutritionist(@Validated @RequestBody NutritionistRequestDTO nutritionistDTO) {
        NutritionistResponseDTO createdNutritionist = nutritionistService.createNutritionist(nutritionistDTO);
        return new ResponseEntity<>(createdNutritionist, HttpStatus.CREATED);
    }


    
}