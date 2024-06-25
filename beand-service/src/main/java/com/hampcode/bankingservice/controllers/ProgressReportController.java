package com.hampcode.bankingservice.controllers;

import com.hampcode.bankingservice.model.dto.ProgressReportRequestDTO;
import com.hampcode.bankingservice.model.dto.ProgressReportResponseDTO;
import com.hampcode.bankingservice.services.ProgressReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress-reports")
@AllArgsConstructor
public class ProgressReportController {

    private final ProgressReportService progressReportService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProgressReportResponseDTO>> getAllProgressReports(@PathVariable Long userId){
        List<ProgressReportResponseDTO> reports = progressReportService.getAllProgressReports(userId);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgressReportResponseDTO> createProgressReport(@Validated @RequestBody ProgressReportRequestDTO progressReportRequestDTO) {
        ProgressReportResponseDTO createdReport = progressReportService.createProgressReport(progressReportRequestDTO);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }
}