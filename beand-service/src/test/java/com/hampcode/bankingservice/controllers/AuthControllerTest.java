package com.hampcode.bankingservice.controllers;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hampcode.bankingservice.model.dto.AccountRequestDTO;
import com.hampcode.bankingservice.services.AuthService;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authservice;


    @Test
    public void testLogin_Successful() throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        AccountRequestDTO loginRequest = new AccountRequestDTO();
        loginRequest.setTypeAccount("user");
        loginRequest.setOwnerEmail("owner@example.com");
        loginRequest.setPassword(passwordEncoder.encode("master123"));

        String loginRequestJson = asJsonString(loginRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginRequestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Inicio de sesión exitoso"));
    }

    @Test
    public void testLogin_Unsuccessful() throws Exception {
        
        AccountRequestDTO loginRequest = new AccountRequestDTO();
        loginRequest.setOwnerEmail("owner@example.com");
        loginRequest.setPassword("wrongpassword");
        loginRequest.setTypeAccount("user");

        String loginRequestJson = asJsonString(loginRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginRequestJson))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized()).andExpect(MockMvcResultMatchers.content().string("Credenciales inválidas"));
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
