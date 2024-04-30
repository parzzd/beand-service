package com.hampcode.bankingservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.model.entities.Account;
import com.hampcode.bankingservice.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean authenticate(String ownerEmail, String password) {
        // Buscar la cuenta por el correo electrónico del titular
        Account account = accountRepository.findByOwnerEmail(ownerEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada para el correo electrónico: " + ownerEmail));

        // Verificar la contraseña
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, account.getPassword());
    }
}