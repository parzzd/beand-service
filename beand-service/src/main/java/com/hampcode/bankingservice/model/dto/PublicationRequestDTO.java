package com.hampcode.bankingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationRequestDTO {

    private String publicationTitle;
    private String publicationDescription;
    private Long sourceUserId;
}