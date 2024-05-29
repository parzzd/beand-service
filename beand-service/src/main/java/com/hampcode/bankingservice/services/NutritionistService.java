package com.hampcode.bankingservice.services;

import com.hampcode.bankingservice.mapper.NutritionistMapper;
import com.hampcode.bankingservice.model.dto.NutritionistRequestDTO;
import com.hampcode.bankingservice.model.dto.NutritionistResponseDTO;
import com.hampcode.bankingservice.model.entities.Nutritionist;
import com.hampcode.bankingservice.repository.NutritionistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class NutritionistService {

    private final NutritionistRepository nutritionistRepository;
    private final NutritionistMapper nutritionistMapper;

    @Transactional
    public NutritionistResponseDTO createNutritionist(NutritionistRequestDTO nutritionistRequestDTO) {
        Nutritionist nutritionist = nutritionistMapper.convertToEntity(nutritionistRequestDTO);
        nutritionist = nutritionistRepository.save(nutritionist);
        return nutritionistMapper.convertToDTO(nutritionist);
    }
}
