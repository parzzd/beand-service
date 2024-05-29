package com.hampcode.bankingservice.mapper;

import com.hampcode.bankingservice.model.dto.NutritionistRequestDTO;
import com.hampcode.bankingservice.model.dto.NutritionistResponseDTO;
import com.hampcode.bankingservice.model.entities.Nutritionist;
import com.hampcode.bankingservice.model.entities.User;
import com.hampcode.bankingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NutritionistMapper {

    @Autowired
    private UserRepository userRepository;

    public Nutritionist convertToEntity(NutritionistRequestDTO nutritionistRequestDTO) {
        Nutritionist nutritionist = new Nutritionist();
        nutritionist.setOwnerName(nutritionistRequestDTO.getOwnerName());
        nutritionist.setOwnerLastName(nutritionistRequestDTO.getOwnerLastName());
        nutritionist.setOwnerCareer(nutritionistRequestDTO.getOwnerCareer());

        User user = userRepository.findById(nutritionistRequestDTO.getUserId()).orElse(null);
        nutritionist.setUser(user);

        return nutritionist;
    }

    public NutritionistResponseDTO convertToDTO(Nutritionist nutritionist) {
        NutritionistResponseDTO nutritionistResponseDTO = new NutritionistResponseDTO();
        nutritionistResponseDTO.setId(nutritionist.getId());
        nutritionistResponseDTO.setOwnerName(nutritionist.getOwnerName());
        nutritionistResponseDTO.setOwnerLastName(nutritionist.getOwnerLastName());
        nutritionistResponseDTO.setOwnerCareer(nutritionist.getOwnerCareer());
        nutritionistResponseDTO.setUserId(nutritionist.getUser().getId());
        return nutritionistResponseDTO;
    }
}