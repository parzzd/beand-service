package com.hampcode.bankingservice.mapper;

import com.hampcode.bankingservice.model.dto.ProgressReportRequestDTO;
import com.hampcode.bankingservice.model.dto.ProgressReportResponseDTO;
import com.hampcode.bankingservice.model.entities.ProgressReport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import org.modelmapper.ModelMapper;

@Component
@AllArgsConstructor
public class ProgressReportMapper {

    private final ModelMapper modelMapper;

    public ProgressReport convertToEntity(ProgressReportRequestDTO progressReportRequestDTO) {
        return modelMapper.map(progressReportRequestDTO, ProgressReport.class);
    }

    public ProgressReportResponseDTO convertToDto(ProgressReport progressReport) {
        return modelMapper.map(progressReport, ProgressReportResponseDTO.class);
    }

    public List<ProgressReportResponseDTO> convertToListDTO(List<ProgressReport> progressReports){
        return progressReports.stream()
                .map(this::convertToDto)
                .toList();
    }
}