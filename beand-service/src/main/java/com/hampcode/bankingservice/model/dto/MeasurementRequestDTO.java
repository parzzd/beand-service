package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementRequestDTO {
    @NotNull(message = "El ID del usuario no puede estar vacío")
    private Long userId;
    
    @NotNull(message = "El peso no puede estar vacío")
    private Double weight;
    
    @NotNull(message = "La altura no puede estar vacía")
    private Double height;
    
    @NotNull(message = "La fecha no puede estar vacía")
    private LocalDate date;
}