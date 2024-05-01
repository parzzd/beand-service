package com.hampcode.bankingservice.mapper;

import com.hampcode.bankingservice.model.dto.AccountResponseDTO;
import com.hampcode.bankingservice.model.dto.NutritionistRequestDTO;
import com.hampcode.bankingservice.model.dto.NutritionistResponseDTO;
import com.hampcode.bankingservice.model.entities.Account;
import com.hampcode.bankingservice.model.entities.Nutritionist;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import org.modelmapper.ModelMapper;


@Component
@AllArgsConstructor
public class NutritionistMapper {

    private final ModelMapper modelMapper;

    

    // Método para convertir de Nutritionist a NutritionistResponseDTO
    public Nutritionist convertToEntity(NutritionistRequestDTO Nutritionistrdto) {
        return modelMapper.map(Nutritionistrdto, Nutritionist.class);
    }

    // Método para convertir de NutritionistResponseDTO a Nutritionist
    public NutritionistResponseDTO convertToDto(Nutritionist nutritionist_) {
        return modelMapper.map(nutritionist_, NutritionistResponseDTO.class);
    }

    public List<NutritionistResponseDTO>  convertToListDTO(List<Nutritionist> nutritionists){
        return nutritionists.stream()
                .map(this::convertToDto)
                .toList();
    }

}
