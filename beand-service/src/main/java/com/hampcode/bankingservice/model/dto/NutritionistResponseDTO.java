package com.hampcode.bankingservice.model.dto;

import java.sql.Blob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NutritionistResponseDTO {
     private Long id; // ID del nutricionista
    private String ownerName; // Nombre del propietario
    private String ownerLastName; // Apellido del propietario
    private String ownerCareer; // Carrera del propietario
   /*  private Blob ownerCv; // CV del propietario como Blob */
}
