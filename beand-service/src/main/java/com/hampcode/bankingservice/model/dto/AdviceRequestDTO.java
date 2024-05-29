package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdviceRequestDTO {

    @NotBlank(message = "El título no puede estar vacío")
    @Size(min=5, max=100, message = "El título debe tener entre 5 a 100 caracteres")
    private String title;

    @NotBlank(message = "El contenido no puede estar vacío")
    @Size(min=10, max=1000, message = "El contenido debe tener entre 10 a 1000 caracteres")
    private String content;

    @NotNull(message = "El ID del nutricionista no puede estar vacío")
    private Long nutritionistId;
}
