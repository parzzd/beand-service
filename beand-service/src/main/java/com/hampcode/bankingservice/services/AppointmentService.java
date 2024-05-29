package com.hampcode.bankingservice.services;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.mapper.AppointmentMapper;
import com.hampcode.bankingservice.model.dto.AppointmentRequestDTO;
import com.hampcode.bankingservice.model.dto.AppointmentResponseDTO;
import com.hampcode.bankingservice.model.entities.Appointment;
import com.hampcode.bankingservice.model.entities.Nutritionist;
import com.hampcode.bankingservice.model.entities.User;
import com.hampcode.bankingservice.repository.AppointmentRepository;
import com.hampcode.bankingservice.repository.NutritionistRepository;
import com.hampcode.bankingservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final NutritionistRepository nutritionistRepository;
    private final AppointmentMapper appointmentMapper;

    @Transactional(readOnly = true)
    public List<AppointmentResponseDTO> getAllAppointments(){
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointmentMapper.convertToListDTO(appointments);
    }

    @Transactional(readOnly = true)
    public AppointmentResponseDTO getAppointmentById(Long id){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta no encontrada con el ID: " + id));
        return appointmentMapper.convertToDTO(appointment);
    }

    @Transactional
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO){
        User user = userRepository.findById(appointmentRequestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID: " + appointmentRequestDTO.getUserId()));
        Nutritionist nutritionist = nutritionistRepository.findById(appointmentRequestDTO.getNutritionistId())
                .orElseThrow(() -> new ResourceNotFoundException("Nutricionista no encontrado con el ID: " + appointmentRequestDTO.getNutritionistId()));

        Appointment appointment = appointmentMapper.convertToEntity(appointmentRequestDTO);
        appointment.setCreatedDate(LocalDateTime.now());
        appointment.setUser(user);
        appointment.setNutritionist(nutritionist);

        appointmentRepository.save(appointment);
        return appointmentMapper.convertToDTO(appointment);
    }

    @Transactional
    public void deleteAppointment(Long id){
        if (!appointmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Consulta no encontrada con el ID: " + id);
        }
        appointmentRepository.deleteById(id);
    }
}
