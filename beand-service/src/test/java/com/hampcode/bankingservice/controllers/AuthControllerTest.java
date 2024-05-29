package com.hampcode.bankingservice.controllers;

import org.junit.Test;
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
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_Login_Successful() throws Exception{

        AccountRequestDTO loginRequest = new AccountRequestDTO();
        loginRequest.setOwnerEmail("owner@example.com");
        loginRequest.setPassword("password123");
        loginRequest.setTypeAccount("user");


        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("Inicio de sesión exitoso"));
    }

    @Test
    public void testLogin_Unsuccessful() throws Exception {
        // Given
        AccountRequestDTO loginRequest = new AccountRequestDTO();
        loginRequest.setOwnerEmail("owner@example.com");
        loginRequest.setPassword("wrongpassword");
        loginRequest.setTypeAccount("user");

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized()).andExpect(MockMvcResultMatchers.content().string("Credenciales inválidas"));
    }
}
