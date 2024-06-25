package com.hampcode.bankingservice.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.repository.WeeklyReportRepository;
import com.hampcode.bankingservice.model.dto.WeeklyReportRequestDTO;
import com.hampcode.bankingservice.model.dto.WeeklyReportResponseDTO;
import com.hampcode.bankingservice.model.entities.WeeklyReport;
import com.hampcode.bankingservice.mapper.WeeklyReportMapper;

import lombok.AllArgsConstructor;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;
@Service
@AllArgsConstructor
public class WeeklyReportService {
    private final WeeklyReportRepository weeklyReportRepository;
    private final WeeklyReportMapper weeklyReportMapper;

    @Transactional(readOnly = true)
    public List<WeeklyReportResponseDTO> getAllWeeklyReports() {
        List<WeeklyReport> reports = weeklyReportRepository.findAll();
        return weeklyReportMapper.convertToListDTO(reports);
    }

    @Transactional(readOnly = true)
    public WeeklyReportResponseDTO getWeeklyReportById(Long id) {
        WeeklyReport report = weeklyReportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found"));
        return weeklyReportMapper.convertToDto(report);
    }

    @Transactional
    public WeeklyReportResponseDTO createWeeklyReport(WeeklyReportRequestDTO requestDTO) {
        WeeklyReport report = weeklyReportMapper.convertToEntity(requestDTO);
        weeklyReportRepository.save(report);
        return weeklyReportMapper.convertToDto(report);
    }

    @Transactional
    public WeeklyReportResponseDTO updateWeeklyReport(Long id, WeeklyReportRequestDTO requestDTO) {
        WeeklyReport existingReport = weeklyReportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found"));
        weeklyReportMapper.updateEntityFromDto(requestDTO, existingReport);
        weeklyReportRepository.save(existingReport);
        return weeklyReportMapper.convertToDto(existingReport);
    }

    @Transactional
    public void deleteWeeklyReport(Long id) {
        WeeklyReport report = weeklyReportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found"));
        weeklyReportRepository.delete(report);
    }
}