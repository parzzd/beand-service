package com.hampcode.bankingservice.model.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    String ownerEmail;
    String ownerPassword;
    private Set<IngredientResponseDTO> restrictions;

}
