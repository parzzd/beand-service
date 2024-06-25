package com.hampcode.bankingservice.controllers;

import com.hampcode.bankingservice.model.dto.GoalRequestDTO;
import com.hampcode.bankingservice.model.dto.GoalResponseDTO;
import com.hampcode.bankingservice.services.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals")
@AllArgsConstructor
public class GoalController {

    private final GoalService goalService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GoalResponseDTO>> getGoalsByUserId(@PathVariable Long userId) {
        List<GoalResponseDTO> goals = goalService.getGoalsByUserId(userId);
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GoalResponseDTO> createGoal(@Validated @RequestBody GoalRequestDTO goalRequestDTO) {
        GoalResponseDTO createdGoal = goalService.createGoal(goalRequestDTO);
        return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
    }
}