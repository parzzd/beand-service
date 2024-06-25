package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalRequestDTO {
    @NotBlank(message = "La descripción no puede estar vacía")
    private String description;

    @NotNull(message = "La fecha objetivo no puede estar vacía")
    private LocalDate targetDate;

    @NotNull(message = "El ID del usuario no puede estar vacío")
    private Long userId;
}