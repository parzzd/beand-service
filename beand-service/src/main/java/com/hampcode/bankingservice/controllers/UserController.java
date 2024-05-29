package com.hampcode.bankingservice.controllers;

import com.hampcode.bankingservice.model.dto.UserRequestDTO;
import com.hampcode.bankingservice.model.dto.UserResponseDTO;
import com.hampcode.bankingservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Validated @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }
}
