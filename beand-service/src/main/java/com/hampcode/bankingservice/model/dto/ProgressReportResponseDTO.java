package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgressReportResponseDTO {

    private Long id; // ID del informe
    private LocalDateTime reportDate; // Fecha del informe
    private Double weightChange; // Cambio de peso
    private String habitsImproved; // Hábitos mejorados
    private String goalsMet; // Objetivos alcanzados
    private String comments; // Comentarios adicionales
}