package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionistResponseDTO {
    private Long id;
    private String ownerName;
    private String ownerLastName;
    private String ownerCareer;
    private Long userId;
}
