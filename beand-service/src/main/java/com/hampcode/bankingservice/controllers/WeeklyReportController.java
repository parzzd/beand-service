package com.hampcode.bankingservice.controllers;

import com.hampcode.bankingservice.model.dto.WeeklyReportRequestDTO;
import com.hampcode.bankingservice.model.dto.WeeklyReportResponseDTO;
import com.hampcode.bankingservice.services.WeeklyReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weekly-reports")
@AllArgsConstructor
public class WeeklyReportController {
    private final WeeklyReportService weeklyReportService;

    @GetMapping
    public ResponseEntity<List<WeeklyReportResponseDTO>> getAllWeeklyReports() {
        List<WeeklyReportResponseDTO> reports = weeklyReportService.getAllWeeklyReports();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeeklyReportResponseDTO> getWeeklyReportById(@PathVariable Long id) {
        WeeklyReportResponseDTO report = weeklyReportService.getWeeklyReportById(id);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @PostMapping("/generate")
    public ResponseEntity<WeeklyReportResponseDTO> createWeeklyReport(@RequestBody WeeklyReportRequestDTO requestDTO) {
        WeeklyReportResponseDTO createdReport = weeklyReportService.createWeeklyReport(requestDTO);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeeklyReportResponseDTO> updateWeeklyReport(@PathVariable Long id, @RequestBody WeeklyReportRequestDTO requestDTO) {
        WeeklyReportResponseDTO updatedReport = weeklyReportService.updateWeeklyReport(id, requestDTO);
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeeklyReport(@PathVariable Long id) {
        weeklyReportService.deleteWeeklyReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}