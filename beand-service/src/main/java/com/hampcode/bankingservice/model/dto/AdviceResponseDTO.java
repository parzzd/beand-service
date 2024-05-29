package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdviceResponseDTO {
    private Long id;
    private String title;
    private String content;
    private Long nutritionistId;
    public Object getMessage() {
        throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
    }
}
