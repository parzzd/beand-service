package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalResponseDTO {
    private Long id;
    private String description;
    private LocalDate targetDate;
    private Boolean achieved;
}