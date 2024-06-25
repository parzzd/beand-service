package com.hampcode.bankingservice.model.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String createdAt;
}