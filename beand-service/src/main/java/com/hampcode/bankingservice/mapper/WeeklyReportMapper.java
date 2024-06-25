package com.hampcode.bankingservice.mapper;

import com.hampcode.bankingservice.model.dto.WeeklyReportRequestDTO;
import com.hampcode.bankingservice.model.dto.WeeklyReportResponseDTO;
import com.hampcode.bankingservice.model.entities.WeeklyReport;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class WeeklyReportMapper {
    private final ModelMapper modelMapper;

    public WeeklyReport convertToEntity(WeeklyReportRequestDTO dto) {
        return modelMapper.map(dto, WeeklyReport.class);
    }

    public WeeklyReportResponseDTO convertToDto(WeeklyReport entity) {
        return modelMapper.map(entity, WeeklyReportResponseDTO.class);
    }

    public void updateEntityFromDto(WeeklyReportRequestDTO dto, WeeklyReport entity) {
        modelMapper.map(dto, entity);
    }

    public List<WeeklyReportResponseDTO> convertToListDTO(List<WeeklyReport> entities) {
        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}