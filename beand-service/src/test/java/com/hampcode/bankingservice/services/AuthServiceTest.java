package com.hampcode.bankingservice.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.model.entities.Account;
import com.hampcode.bankingservice.repository.AccountRepository;
public class AuthServiceTest {
    
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AuthService authService;

    private Account account;
    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp(){
        passwordEncoder = new BCryptPasswordEncoder();
        
        account = new Account();
        account.setTypeAccount("user");
        account.setOwnerEmail("ejemplo@upc.edu.pe");
        account.setPassword(passwordEncoder.encode("password123"));
    }
    @Test
    public void testAuthenticateSuccess() {
        when(accountRepository.findByOwnerEmail("ejemplo@upc.edu.pe")).thenReturn(Optional.of(account));
        
        boolean result = authService.authenticate("ejemplo@upc.edu.pe", "password123", "user");
        
        assertTrue(result);
        verify(accountRepository, times(1)).findByOwnerEmail("ejemplo@upc.edu.pe");
    }

    @Test
    public void testAuthenticateFailureInvalidPassword() {
        when(accountRepository.findByOwnerEmail("ejemplo@upc.edu.pe")).thenReturn(Optional.of(account));
        
        boolean result = authService.authenticate("ejemplo@upc.edu.pe", "wrongpassword", "user");
        
        assertFalse(result);
        verify(accountRepository, times(1)).findByOwnerEmail("ejemplo@upc.edu.pe");
    }

        @Test
    public void testAuthenticateAccountNotFound() {
        when(accountRepository.findByOwnerEmail("ejemplo@upc.edu.pe")).thenReturn(Optional.of(account));

        assertThrows(ResourceNotFoundException.class, () -> {
            authService.authenticate("ejemplo@upc.edu.pe", "password123", "user");
        });
        
        verify(accountRepository, times(1)).findByOwnerEmail("ejemplo@upc.edu.pe");
    }
}
