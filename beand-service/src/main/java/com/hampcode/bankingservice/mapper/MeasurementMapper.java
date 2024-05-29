package com.hampcode.bankingservice.mapper;

import com.hampcode.bankingservice.model.dto.MeasurementRequestDTO;
import com.hampcode.bankingservice.model.dto.MeasurementResponseDTO;
import com.hampcode.bankingservice.model.entities.Measurement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.List;

@Component
@AllArgsConstructor
public class MeasurementMapper {

    private final ModelMapper modelMapper;

    public Measurement convertToEntity(MeasurementRequestDTO measurementRequestDTO){
        return modelMapper.map(measurementRequestDTO, Measurement.class);
    }

    public MeasurementResponseDTO convertToDTO(Measurement measurement){
        return modelMapper.map(measurement, MeasurementResponseDTO.class);
    }

    public List<MeasurementResponseDTO> convertToListDTO(List<Measurement> measurements){
        return measurements.stream()
                .map(this::convertToDTO)
                .toList();
    }
}