package com.hampcode.bankingservice.controllers;

import com.hampcode.bankingservice.model.dto.EmailRequestDTO;
import com.hampcode.bankingservice.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<Void> sendEmail(@RequestBody EmailRequestDTO requestDTO) {
        emailService.sendEmailWithReport(requestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}