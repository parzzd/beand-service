package com.hampcode.bankingservice.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyReportRequestDTO {
    @NotNull
    private Long userId;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    private String progressSummary;
    private Double weightChange;
    private String habitsImprovement;
    private String goalsAchievement;
}