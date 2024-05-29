package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDTO {
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;
    private Long userId;
    private Long nutritionistId;
}