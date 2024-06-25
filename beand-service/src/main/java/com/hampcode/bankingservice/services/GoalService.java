package com.hampcode.bankingservice.services;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.mapper.GoalMapper;
import com.hampcode.bankingservice.model.dto.GoalRequestDTO;
import com.hampcode.bankingservice.model.dto.GoalResponseDTO;
import com.hampcode.bankingservice.model.entities.Goal;
import com.hampcode.bankingservice.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;
    private final GoalMapper goalMapper;

    @Transactional(readOnly = true)
    public List<GoalResponseDTO> getGoalsByUserId(Long userId) {
        List<Goal> goals = goalRepository.findByUserId(userId);
        return goalMapper.convertToListDTO(goals);
    }

    @Transactional
    public GoalResponseDTO createGoal(GoalRequestDTO goalRequestDTO) {
        Goal goal = goalMapper.convertToEntity(goalRequestDTO);
        goalRepository.save(goal);
        return goalMapper.convertToDto(goal);
    }
}