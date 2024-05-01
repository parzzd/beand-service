package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationResponseDTO {

    private Long id;
    private String publicationTitle;
    private String publicationDescription;
    private Long sourceUserId;
}