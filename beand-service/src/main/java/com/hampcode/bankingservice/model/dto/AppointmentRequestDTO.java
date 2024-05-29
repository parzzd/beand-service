package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDTO {
    @NotNull(message = "La fecha de la consulta no puede estar vacía")
    @Future(message = "La fecha de la consulta debe ser en el futuro")
    private LocalDateTime dueDate;

    @NotNull(message = "El ID del usuario no puede estar vacío")
    private Long userId;

    @NotNull(message = "El ID del nutricionista no puede estar vacío")
    private Long nutritionistId;
}
