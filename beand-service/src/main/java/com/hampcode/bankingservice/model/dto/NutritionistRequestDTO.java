package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionistRequestDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String ownerName;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String ownerLastName;

    @NotBlank(message = "La carrera no puede estar vacía")
    private String ownerCareer;

    private Long userId;
}
