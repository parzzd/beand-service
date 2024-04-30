package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.hampcode.bankingservice.model.entities.UserRestriction;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    
    private List<UserRestriction> restrictions;
    @NotBlank(message = "El correo electronico del titular no puede estar vacio")
    @Email
    private String ownerEmail;
}