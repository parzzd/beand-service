// package com.hampcode.bankingservice.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.hampcode.bankingservice.model.dto.AccountRequestDTO;
// import com.hampcode.bankingservice.services.AccountService;

// @RestController
// public class AuthController {

    
//     AccountService accountService;

//     @PostMapping("/login")
//     public ResponseEntity<String> login(@Validated @RequestBody AccountRequestDTO accountDTO) {
//         String ownerEmail = accountDTO.getOwnerEmail();
//         String password = accountDTO.getPassword();

//         boolean isAuthenticated = accountService.authenticate(ownerEmail, password);

//         if (isAuthenticated) {
//             return new ResponseEntity<>("Inicio de sesión exitoso", HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
//         }
//     }
// }