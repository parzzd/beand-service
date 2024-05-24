package com.hampcode.bankingservice.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

import com.hampcode.bankingservice.model.dto.IngredientResponseDTO;
import com.hampcode.bankingservice.model.dto.UserRequestDTO;
import com.hampcode.bankingservice.model.dto.UserResponseDTO;
import com.hampcode.bankingservice.model.entities.User;

import lombok.AllArgsConstructor;
@Controller
@AllArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;
    public User convertToEntity(UserRequestDTO userRequestDTO){
        return modelMapper.map(userRequestDTO, User.class);

    }
    public UserResponseDTO convertToUserDTO(User user){
        return modelMapper.map(user, UserResponseDTO.class);
    }
    public List<UserResponseDTO> convertToListUserDTO(List<User> users){
        return users.stream().map(this::convertToUserDTO).toList();
    }

    public UserResponseDTO convertToUserDTOO(User user){
        UserResponseDTO dto=new UserResponseDTO();
        dto.setOwnerEmail(user.getOwnerEmail());
        dto.setOwnerPassword(user.getOwnerPassword());

        Set<IngredientResponseDTO> ingredientDTOs = user.getCannotConsumeIngredients().stream()
        .map(ingredient -> {
                IngredientResponseDTO ingredientDTO = new IngredientResponseDTO();
                ingredientDTO.setId(ingredient.getId());
                ingredientDTO.setIngredientName(ingredient.getIngredientName());
                return ingredientDTO;
            }).collect(Collectors.toSet());
        dto.setIngredients(ingredientDTOs);

        return dto;
    }
}
