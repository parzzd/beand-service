package com.hampcode.bankingservice.model.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "progress_reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgressReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "report_date", nullable = false)
    private LocalDateTime reportDate;

    @Column(name = "weight_change")
    private Double weightChange;

    @Column(name = "habits_improved")
    private String habitsImproved;

    @Column(name = "goals_met")
    private String goalsMet;

    @Column(name = "comments", length = 1000)
    private String comments;
}