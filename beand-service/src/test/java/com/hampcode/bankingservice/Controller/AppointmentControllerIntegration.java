package com.hampcode.bankingservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hampcode.bankingservice.model.dto.AppointmentRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateAppointment() throws Exception {
        AppointmentRequestDTO requestDTO = new AppointmentRequestDTO();
        requestDTO.setUserId(1L); // Ajusta estos IDs según los datos en tu base de datos
        requestDTO.setNutritionistId(1L);
        requestDTO.setDueDate(LocalDateTime.now().plusDays(1));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/appointments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testGetAppointmentById() throws Exception {
        Long appointmentId = 1L; // Ajusta este ID según los datos en tu base de datos

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/appointments/{id}", appointmentId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAllAppointments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/appointments"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateAppointment() throws Exception {
        Long appointmentId = 1L; // Ajusta este ID según los datos en tu base de datos

        AppointmentRequestDTO requestDTO = new AppointmentRequestDTO();
        requestDTO.setUserId(1L); // Ajusta estos IDs según los datos en tu base de datos
        requestDTO.setNutritionistId(1L);
        requestDTO.setDueDate(LocalDateTime.now().plusDays(1));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/appointments/{id}", appointmentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteAppointment() throws Exception {
        Long appointmentId = 1L; // Ajusta este ID según los datos en tu base de datos

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/appointments/{id}", appointmentId))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    // Método auxiliar para convertir objetos a JSON
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
