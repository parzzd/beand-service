package com.hampcode.bankingservice.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.hampcode.bankingservice.mapper.UserMapper;
import com.hampcode.bankingservice.model.dto.UserRequestDTO;
import com.hampcode.bankingservice.model.dto.UserResponseDTO;
import com.hampcode.bankingservice.model.entities.Ingredient;
import com.hampcode.bankingservice.model.entities.User;
import com.hampcode.bankingservice.repository.IngredientRepository;
import com.hampcode.bankingservice.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserService {
    private final IngredientRepository ingredientRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponseDTO> getAllUsers(){
        List<User> users=userRepository.findAll();
        return userMapper.convertToListUserDTO(users);
    }
    

    
    @Transactional
    public UserResponseDTO createUserResponseDTO(UserRequestDTO userRequestDTO){
        User user=new User();
        user.setOwnerEmail(userRequestDTO.getOwnerEmail());
        user.setOwnerPassword(userRequestDTO.getOwnerPassword());

        for (String ingredientName : userRequestDTO.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findByIngredientName(ingredientName);
            if (ingredient == null) {
                ingredient = new Ingredient();
                ingredient.setIngredientName(ingredientName);
                ingredient = ingredientRepository.save(ingredient);
            }
            user.addIngredient(ingredient);
        }
        user = userRepository.save(user); 
        return userMapper.convertToUserDTO(user);

    }
    @Transactional
    public UserResponseDTO findUserByID(String UserID){
        User user=userRepository.findUser(UserID);
        return userMapper.convertToUserDTOO(user);
    }




}
