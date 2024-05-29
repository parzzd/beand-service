package com.hampcode.bankingservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hampcode.bankingservice.model.dto.AccountRequestDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testCreateAccount() throws Exception{

        AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
        accountRequestDTO.setTypeAccount("user");
        accountRequestDTO.setOwnerEmail("owner@example.com");
        accountRequestDTO.setPassword("password123");
        

        mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(accountRequestDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

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
