package com.hampcode.bankingservice.model.dto;

import java.sql.Blob;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NutritionistRequestDTO {
    @NotNull(message = "El ID no puede estar vacío")
    private Long id;

    @NotBlank(message = "El nombre del propietario no puede estar vacío")
    private String ownerName;

    @NotBlank(message = "El apellido del propietario no puede estar vacío")
    private String ownerLastName;

    @NotBlank(message = "La carrera del propietario no puede estar vacía")
    private String ownerCareer;

    /* @NotNull(message = "El CV del propietario no puede estar vacío")
    private Blob ownerCv; */
}
