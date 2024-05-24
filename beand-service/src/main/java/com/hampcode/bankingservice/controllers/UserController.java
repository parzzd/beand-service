package com.hampcode.bankingservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.hampcode.bankingservice.model.dto.UserRequestDTO;
import com.hampcode.bankingservice.model.dto.UserResponseDTO;
import com.hampcode.bankingservice.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Validated UserRequestDTO userRequestDTO){
        UserResponseDTO createUser=userService.createUserResponseDTO(userRequestDTO);
        return new ResponseEntity<>(createUser,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> findUser(@PathVariable String userId) {
        UserResponseDTO user = userService.findUserByID(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
