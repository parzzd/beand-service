package com.hampcode.bankingservice.services;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.mapper.MeasurementMapper;
import com.hampcode.bankingservice.model.dto.MeasurementRequestDTO;
import com.hampcode.bankingservice.model.dto.MeasurementResponseDTO;
import com.hampcode.bankingservice.model.entities.Measurement;
import com.hampcode.bankingservice.repository.MeasurementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;

    @Transactional(readOnly = true)
    public List<MeasurementResponseDTO> getAllMeasurements() {
        List<Measurement> measurements = measurementRepository.findAll();
        return measurementMapper.convertToListDTO(measurements);
    }

    @Transactional(readOnly = true)
    public MeasurementResponseDTO getMeasurementById(Long id) {
        Measurement measurement = measurementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medición no encontrada con el ID: " + id));
        return measurementMapper.convertToDTO(measurement);
    }

    @Transactional
    public MeasurementResponseDTO createMeasurement(MeasurementRequestDTO measurementRequestDTO) {
        Measurement measurement = measurementMapper.convertToEntity(measurementRequestDTO);
        measurement.setDate(LocalDate.now()); 
        measurementRepository.save(measurement);
        return measurementMapper.convertToDTO(measurement);
    }

    @Transactional
    public MeasurementResponseDTO updateMeasurement(Long id, MeasurementRequestDTO measurementRequestDTO) {
        Measurement measurement = measurementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medición no encontrada con el ID: " + id));

        measurement.setUserId(measurementRequestDTO.getUserId());
        measurement.setWeight(measurementRequestDTO.getWeight());
        measurement.setHeight(measurementRequestDTO.getHeight());
        measurement.setDate(measurementRequestDTO.getDate());

        measurement = measurementRepository.save(measurement);

        return measurementMapper.convertToDTO(measurement);
    }

    @Transactional
    public void deleteMeasurement(Long id) {
        measurementRepository.deleteById(id);
    }
}