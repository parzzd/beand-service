/*package com.hampcode.bankingservice.Services;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.mapper.MeasurementMapper;
import com.hampcode.bankingservice.services.*;
import com.hampcode.bankingservice.model.dto.MeasurementRequestDTO;
import com.hampcode.bankingservice.model.dto.MeasurementResponseDTO;
import com.hampcode.bankingservice.model.entities.Measurement;
import com.hampcode.bankingservice.repository.MeasurementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MeasurementServiceTest {

    @Mock
    private MeasurementRepository measurementRepository;

    @Mock
    private MeasurementMapper measurementMapper;

    @InjectMocks
    private MeasurementService measurementService;

    @Test
    public void testGetMeasurementsByUserId() {
        // Arrange
        Long userId = 1L;
        when(measurementRepository.findById(userId)).thenReturn(Collections.emptyList());

        // Act
        List<MeasurementResponseDTO> result = measurementService.getMeasurementsByUserId(userId);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testCreateMeasurement() {
        // Arrange
        MeasurementRequestDTO requestDTO = new MeasurementRequestDTO();
        requestDTO.setUserId(1L);
        requestDTO.setWeight(70.5);
        requestDTO.setHeight(175.0);
        requestDTO.setDate(LocalDate.now());

        Measurement measurement = new Measurement();
        measurement.setId(1L);
        measurement.setUserId(1L);
        measurement.setWeight(70.5);
        measurement.setHeight(175.0);
        measurement.setDate(LocalDate.now());

        when(measurementMapper.convertToEntity(requestDTO)).thenReturn(measurement);
        when(measurementRepository.save(measurement)).thenReturn(measurement);
        when(measurementMapper.convertToDTO(measurement)).thenReturn(new MeasurementResponseDTO());

        // Act
        MeasurementResponseDTO result = measurementService.createMeasurement(requestDTO);

        // Assert
        assertNotNull(result);
        assertEquals(1L, measurement.getUserId());
        assertEquals(70.5, measurement.getWeight());
        assertEquals(175.0, measurement.getHeight());
    }

    @Test
    public void testGetMeasurementById() {
        // Arrange
        Long measurementId = 1L;
        Measurement measurement = new Measurement();
        measurement.setId(measurementId);
        measurement.setUserId(1L);
        measurement.setWeight(70.5);
        measurement.setHeight(175.0);
        measurement.setDate(LocalDate.now());

        when(measurementRepository.findById(measurementId)).thenReturn(Optional.of(measurement));
        when(measurementMapper.convertToDTO(measurement)).thenReturn(new MeasurementResponseDTO());

        // Act
        MeasurementResponseDTO result = measurementService.getMeasurementById(measurementId);

        // Assert
        assertNotNull(result);
    }

    @Test
    public void testGetMeasurementById_NotFound() {
        // Arrange
        Long measurementId = 1L;

        when(measurementRepository.findById(measurementId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> measurementService.getMeasurementById(measurementId));
    }
}*/