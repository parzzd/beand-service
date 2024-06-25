package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgressReportRequestDTO {

    private Long userId; // ID del usuario
    private Double weightChange;
    private String habitsImproved;
    private String goalsMet;
    private String comments;
}