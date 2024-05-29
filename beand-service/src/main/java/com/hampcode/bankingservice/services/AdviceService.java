package com.hampcode.bankingservice.services;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.mapper.AdviceMapper;
import com.hampcode.bankingservice.model.dto.AdviceRequestDTO;
import com.hampcode.bankingservice.model.dto.AdviceResponseDTO;
import com.hampcode.bankingservice.model.entities.Advice;
import com.hampcode.bankingservice.model.entities.Nutritionist;
import com.hampcode.bankingservice.repository.AdviceRepository;
import com.hampcode.bankingservice.repository.NutritionistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AdviceService {

    private final AdviceRepository adviceRepository;
    private final NutritionistRepository nutritionistRepository;
    private final AdviceMapper adviceMapper;

    @Transactional
    public AdviceResponseDTO createAdvice(AdviceRequestDTO adviceRequestDTO) {
        Nutritionist nutritionist = nutritionistRepository.findById(adviceRequestDTO.getNutritionistId())
                .orElseThrow(() -> new ResourceNotFoundException("Nutritionist not found with id: " + adviceRequestDTO.getNutritionistId()));

        Advice advice = adviceMapper.convertToEntity(adviceRequestDTO);
        advice.setNutritionist(nutritionist);
        adviceRepository.save(advice);
        return adviceMapper.convertToDTO(advice);
    }

    @Transactional(readOnly = true)
    public List<AdviceResponseDTO> getAdvicesByNutritionist(Long nutritionistId) {
        List<Advice> advices = adviceRepository.findByNutritionistId(nutritionistId);
        return adviceMapper.convertToListDTO(advices);
    }

    @Transactional(readOnly = true)
    public List<AdviceResponseDTO> getAllAdvices() {
        List<Advice> advices = adviceRepository.findAll();
        return adviceMapper.convertToListDTO(advices);
    }
}
