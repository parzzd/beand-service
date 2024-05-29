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
import com.hampcode.bankingservice.services.AppointmentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private NutritionistRepository nutritionistRepository;

    @Mock
    private AppointmentMapper appointmentMapper;

    @InjectMocks
    private AppointmentService appointmentService;

    private Appointment appointment;
    private User user;
    private Nutritionist nutritionist;
    private AppointmentRequestDTO appointmentRequestDTO;
    private AppointmentResponseDTO appointmentResponseDTO;

    @BeforeEach
    public void setup() {
        user = new User();
        user.setId(1L);
        user.setOwnerEmail("user@example.com");
        user.setOwnerPassword("password");

        nutritionist = new Nutritionist();
        nutritionist.setId(1L);
        nutritionist.setOwnerName("John");
        nutritionist.setOwnerLastName("Doe");

        appointment = new Appointment();
        appointment.setId(1L);
        appointment.setCreatedDate(LocalDateTime.now());
        appointment.setDueDate(LocalDateTime.now().plusDays(1));
        appointment.setUser(user);
        appointment.setNutritionist(nutritionist);

        appointmentRequestDTO = new AppointmentRequestDTO();
        appointmentRequestDTO.setUserId(user.getId());
        appointmentRequestDTO.setNutritionistId(nutritionist.getId());
        appointmentRequestDTO.setDueDate(appointment.getDueDate());

        appointmentResponseDTO = new AppointmentResponseDTO();
        appointmentResponseDTO.setId(appointment.getId());
        appointmentResponseDTO.setCreatedDate(appointment.getCreatedDate());
        appointmentResponseDTO.setDueDate(appointment.getDueDate());
    }

    @Test
    public void testCreateAppointment() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(nutritionistRepository.findById(nutritionist.getId())).thenReturn(Optional.of(nutritionist));
        when(appointmentMapper.convertToEntity(appointmentRequestDTO)).thenReturn(appointment);
        when(appointmentMapper.convertToDTO(appointment)).thenReturn(appointmentResponseDTO);
        when(appointmentRepository.save(appointment)).thenReturn(appointment);

        AppointmentResponseDTO result = appointmentService.createAppointment(appointmentRequestDTO);

        assertNotNull(result);
        assertEquals(appointment.getId(), result.getId());
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    public void testGetAppointmentById() {
        when(appointmentRepository.findById(appointment.getId())).thenReturn(Optional.of(appointment));
        when(appointmentMapper.convertToDTO(appointment)).thenReturn(appointmentResponseDTO);

        AppointmentResponseDTO result = appointmentService.getAppointmentById(appointment.getId());

        assertNotNull(result);
        assertEquals(appointment.getId(), result.getId());
        verify(appointmentRepository, times(1)).findById(appointment.getId());
    }

    @Test
    public void testGetAppointmentById_NotFound() {
        when(appointmentRepository.findById(appointment.getId())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            appointmentService.getAppointmentById(appointment.getId());
        });

        verify(appointmentRepository, times(1)).findById(appointment.getId());
    }
}
