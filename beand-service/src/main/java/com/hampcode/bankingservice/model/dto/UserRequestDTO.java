package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico debe ser válido")
    private String ownerEmail;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String ownerPassword;
}
