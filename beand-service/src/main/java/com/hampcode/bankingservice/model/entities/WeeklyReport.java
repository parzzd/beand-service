package com.hampcode.bankingservice.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "weekly_reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "progress_summary", nullable = true)
    private String progressSummary;

    @Column(name = "weight_change", nullable = true)
    private Double weightChange;

    @Column(name = "habits_improvement", nullable = true)
    private String habitsImprovement;

    @Column(name = "goals_achievement", nullable = true)
    private String goalsAchievement;
}