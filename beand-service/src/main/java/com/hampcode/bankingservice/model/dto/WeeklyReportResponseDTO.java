package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyReportResponseDTO {
    private Long id;
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String progressSummary;
    private Double weightChange;
    private String habitsImprovement;
    private String goalsAchievement;
}