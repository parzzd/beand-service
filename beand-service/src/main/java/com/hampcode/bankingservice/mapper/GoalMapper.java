package com.hampcode.bankingservice.mapper;

import com.hampcode.bankingservice.model.dto.GoalRequestDTO;
import com.hampcode.bankingservice.model.dto.GoalResponseDTO;
import com.hampcode.bankingservice.model.entities.Goal;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GoalMapper {

    private final ModelMapper modelMapper;

    public Goal convertToEntity(GoalRequestDTO goalRequestDTO) {
        return modelMapper.map(goalRequestDTO, Goal.class);
    }

    public GoalResponseDTO convertToDto(Goal goal) {
        return modelMapper.map(goal, GoalResponseDTO.class);
    }

    public List<GoalResponseDTO> convertToListDTO(List<Goal> goals) {
        return goals.stream()
                .map(this::convertToDto)
                .toList();
    }
}