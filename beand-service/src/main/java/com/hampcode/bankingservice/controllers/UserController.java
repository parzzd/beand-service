package com.hampcode.bankingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hampcode.bankingservice.model.entities.User;
import com.hampcode.bankingservice.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<User>> findUsers(@PathVariable Long userId) {
        List<User> users = userService.findUsers(userId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
