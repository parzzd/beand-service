package com.hampcode.bankingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.bankingservice.model.dto.AccountRequestDTO;
import com.hampcode.bankingservice.services.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authservice;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody AccountRequestDTO loginRequest) {

        String ownerEmail = loginRequest.getOwnerEmail();
        String password = loginRequest.getPassword();
        String typeAccount = loginRequest.getTypeAccount();

        boolean isAuthenticated = authservice.authenticate(ownerEmail, password, typeAccount);

        if (isAuthenticated) {
            return new ResponseEntity<>("Inicio de sesión exitoso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
    }

}

