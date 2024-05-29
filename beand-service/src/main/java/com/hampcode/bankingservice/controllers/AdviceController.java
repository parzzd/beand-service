package com.hampcode.bankingservice.controllers;

import com.hampcode.bankingservice.model.dto.AdviceRequestDTO;
import com.hampcode.bankingservice.model.dto.AdviceResponseDTO;
import com.hampcode.bankingservice.services.AdviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advices")
@AllArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;

    @PostMapping
    public ResponseEntity<AdviceResponseDTO> createAdvice(@Validated @RequestBody AdviceRequestDTO adviceRequestDTO) {
        AdviceResponseDTO createdAdvice = adviceService.createAdvice(adviceRequestDTO);
        return new ResponseEntity<>(createdAdvice, HttpStatus.CREATED);
    }

    @GetMapping("/nutritionist/{nutritionistId}")
    public ResponseEntity<List<AdviceResponseDTO>> getAdvicesByNutritionist(@PathVariable Long nutritionistId) {
        List<AdviceResponseDTO> advices = adviceService.getAdvicesByNutritionist(nutritionistId);
        return new ResponseEntity<>(advices, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AdviceResponseDTO>> getAllAdvices() {
        List<AdviceResponseDTO> advices = adviceService.getAllAdvices();
        return new ResponseEntity<>(advices, HttpStatus.OK);
    }
}