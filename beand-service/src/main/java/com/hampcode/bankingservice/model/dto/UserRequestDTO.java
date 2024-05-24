package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    
    
    @NotBlank(message = "El correo electronico del titular no puede estar vacio")
    @Email
    private String ownerEmail;
    
    @NotBlank(message = "contraseña no puede ser nula")
    private String ownerPassword;

    private Set<String> ingredients;
}