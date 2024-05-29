package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementResponseDTO {
    private Long id;
    private Long userId;
    private Double weight;
    private Double height;
    private LocalDate date;
}