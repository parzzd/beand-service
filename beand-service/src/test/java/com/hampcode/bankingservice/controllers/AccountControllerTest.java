package com.hampcode.bankingservice.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hampcode.bankingservice.model.dto.AccountRequestDTO;
import com.hampcode.bankingservice.model.dto.AccountResponseDTO;
import com.hampcode.bankingservice.services.AccountService;

public class AccountControllerTest {
@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AccountService accountService;

    @Test
    public void testCreateAccount() throws Exception{

        AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
        accountRequestDTO.setOwnerEmail("owner@example.com");
        accountRequestDTO.setPassword("password123");
        accountRequestDTO.setTypeAccount("user");

        AccountResponseDTO createdAccount = new AccountResponseDTO();
        createdAccount.setId(1L);
        createdAccount.setOwnerEmail("owner@example.com");
        createdAccount.setTypeAccount("user");

        when(accountService.createAccount(any(AccountRequestDTO.class))).thenReturn(createdAccount);

        mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(accountRequestDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ownerEmail").value("owner@example.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.typeAccount").value("user"));
    }
}
