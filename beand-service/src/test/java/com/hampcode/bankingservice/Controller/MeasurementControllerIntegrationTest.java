/*package com.hampcode.bankingservice.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hampcode.bankingservice.model.dto.MeasurementRequestDTO;
import com.hampcode.bankingservice.model.entities.Measurement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class MeasurementControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMeasurementsByUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/measurements/users/{userId}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateMeasurement() throws Exception {
        MeasurementRequestDTO requestDTO = new MeasurementRequestDTO();
        // Configurar los datos de la solicitud
        requestDTO.setUserId(1L);
        requestDTO.setWeight(70.5);
        requestDTO.setHeight(175.0);
        requestDTO.setDate(LocalDate.now());

        mockMvc.perform(MockMvcRequestBuilders.post("/measurements")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testGetMeasurementById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/measurements/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Método auxiliar para convertir objetos a JSON
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}*/