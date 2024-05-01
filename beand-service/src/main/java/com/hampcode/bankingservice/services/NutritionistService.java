package com.hampcode.bankingservice.services;
import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hampcode.bankingservice.mapper.NutritionistMapper;
import com.hampcode.bankingservice.repository.NutritionistRepository;

import lombok.AllArgsConstructor;

import com.hampcode.bankingservice.model.dto.AccountRequestDTO;
import com.hampcode.bankingservice.model.dto.AccountResponseDTO;
import com.hampcode.bankingservice.model.dto.NutritionistResponseDTO;
import com.hampcode.bankingservice.model.dto.NutritionistRequestDTO;
import com.hampcode.bankingservice.model.entities.Account;
import com.hampcode.bankingservice.model.entities.Nutritionist;

import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
public class NutritionistService {
    private final NutritionistRepository NutritionistRepository;
    private final NutritionistMapper NutritionistMapper;

    @Transactional(readOnly = true)
    public List<NutritionistResponseDTO> getAllNutritionist(){
        List<Nutritionist> nutritionists=NutritionistRepository.findAll();
        return NutritionistMapper.convertToListDTO(nutritionists);
    }

    @Transactional(readOnly = true)
    public NutritionistResponseDTO getNutritionistById(Long id){

        Nutritionist nutritionist = NutritionistRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return NutritionistMapper.convertToDto(nutritionist); 

    }

    @Transactional
    public NutritionistResponseDTO createNutritionist(NutritionistRequestDTO nutritionistRequestDTO){
        Nutritionist nutritionist = NutritionistMapper.convertToEntity(nutritionistRequestDTO);
        NutritionistRepository.save(nutritionist);
        return NutritionistMapper.convertToDto(nutritionist);
    }


}
