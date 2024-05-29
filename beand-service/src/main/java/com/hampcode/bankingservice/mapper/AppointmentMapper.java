package com.hampcode.bankingservice.mapper;

import com.hampcode.bankingservice.model.dto.AppointmentRequestDTO;
import com.hampcode.bankingservice.model.dto.AppointmentResponseDTO;
import com.hampcode.bankingservice.model.entities.Appointment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentMapper {

    private final ModelMapper modelMapper;

    public AppointmentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Appointment convertToEntity(AppointmentRequestDTO appointmentRequestDTO){
        return modelMapper.map(appointmentRequestDTO, Appointment.class);
    }

    public AppointmentResponseDTO convertToDTO(Appointment appointment){
        return modelMapper.map(appointment, AppointmentResponseDTO.class);
    }

    public List<AppointmentResponseDTO> convertToListDTO(List<Appointment> appointments){
        return appointments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}

