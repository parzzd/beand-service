package com.hampcode.bankingservice.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {

    private Long id;
    private String typeAccount;
    private String ownerEmail;
    private List<IngredientResponseDTO>ingredients;

}
