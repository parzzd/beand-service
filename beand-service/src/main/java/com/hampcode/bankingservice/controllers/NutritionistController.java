package com.hampcode.bankingservice.controllers;

import com.hampcode.bankingservice.model.dto.NutritionistRequestDTO;
import com.hampcode.bankingservice.model.dto.NutritionistResponseDTO;
import com.hampcode.bankingservice.services.NutritionistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nutritionists")
@AllArgsConstructor
public class NutritionistController {

    private final NutritionistService nutritionistService;

    @PostMapping
    public ResponseEntity<NutritionistResponseDTO> createNutritionist(@Validated @RequestBody NutritionistRequestDTO nutritionistRequestDTO) {
        NutritionistResponseDTO nutritionistResponseDTO = nutritionistService.createNutritionist(nutritionistRequestDTO);
        return new ResponseEntity<>(nutritionistResponseDTO, HttpStatus.CREATED);
    }
}
