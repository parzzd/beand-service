package com.hampcode.bankingservice.mapper;

import com.hampcode.bankingservice.model.dto.UserRequestDTO;
import com.hampcode.bankingservice.model.dto.UserResponseDTO;
import com.hampcode.bankingservice.model.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User convertToEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setOwnerEmail(userRequestDTO.getOwnerEmail());
        user.setOwnerPassword(userRequestDTO.getOwnerPassword());
        return user;
    }

    public UserResponseDTO convertToDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setOwnerEmail(user.getOwnerEmail());
        return userResponseDTO;
    }
}
