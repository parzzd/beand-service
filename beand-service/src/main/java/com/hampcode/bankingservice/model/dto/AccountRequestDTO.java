package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDTO {

    @Pattern(regexp = "^(user|nutricionist)$", message = "El tipo de cuenta debe ser 'user' o 'nutricionist'")
    private String typeAccount;

    @NotBlank(message = "El correo electronico del titular no puede estar vacio")
    @Email
    private String ownerEmail;
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;
}
