package com.hampcode.bankingservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.bankingservice.model.dto.PublicationRequestDTO;
import com.hampcode.bankingservice.model.dto.PublicationResponseDTO;
import com.hampcode.bankingservice.services.PublicationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/publications")
@AllArgsConstructor
public class PublicationController {

    private final PublicationService publicationService;


    @PostMapping("/create")
    public ResponseEntity<PublicationResponseDTO> createPublication(@Validated @RequestBody
                                                                PublicationRequestDTO publicationDTO) {
        PublicationResponseDTO publicationAccount = publicationService.createPublication(publicationDTO);
        return new ResponseEntity<>(publicationAccount, HttpStatus.CREATED);
    }
}
