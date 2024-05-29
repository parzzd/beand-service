package com.hampcode.bankingservice.controllers;

import com.hampcode.bankingservice.model.dto.MeasurementRequestDTO;
import com.hampcode.bankingservice.model.dto.MeasurementResponseDTO;
import com.hampcode.bankingservice.services.MeasurementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
@AllArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;

    @GetMapping
    public ResponseEntity<List<MeasurementResponseDTO>> getAllMeasurements() {
        List<MeasurementResponseDTO> measurements = measurementService.getAllMeasurements();
        return new ResponseEntity<>(measurements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasurementResponseDTO> getMeasurementById(@PathVariable Long id) {
        MeasurementResponseDTO measurement = measurementService.getMeasurementById(id);
        return new ResponseEntity<>(measurement, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MeasurementResponseDTO> createMeasurement(@Validated @RequestBody MeasurementRequestDTO measurementDTO) {
        MeasurementResponseDTO createdMeasurement = measurementService.createMeasurement(measurementDTO);
        return new ResponseEntity<>(createdMeasurement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeasurementResponseDTO> updateMeasurement(@PathVariable Long id,
                                                                    @Validated @RequestBody MeasurementRequestDTO measurementDTO) {
        MeasurementResponseDTO updatedMeasurement = measurementService.updateMeasurement(id, measurementDTO);
        return new ResponseEntity<>(updatedMeasurement, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasurement(@PathVariable Long id) {
        measurementService.deleteMeasurement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}