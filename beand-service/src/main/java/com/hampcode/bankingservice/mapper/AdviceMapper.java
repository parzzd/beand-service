package com.hampcode.bankingservice.mapper;

import com.hampcode.bankingservice.model.dto.AdviceRequestDTO;
import com.hampcode.bankingservice.model.dto.AdviceResponseDTO;
import com.hampcode.bankingservice.model.entities.Advice;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

import java.util.List;

@Component
@AllArgsConstructor
public class AdviceMapper {

    private final ModelMapper modelMapper;

    public Advice convertToEntity(AdviceRequestDTO adviceRequestDTO) {
        return modelMapper.map(adviceRequestDTO, Advice.class);
    }

    public AdviceResponseDTO convertToDTO(Advice advice) {
        return modelMapper.map(advice, AdviceResponseDTO.class);
    }

    public List<AdviceResponseDTO> convertToListDTO(List<Advice> advices) {
        return advices.stream()
                .map(this::convertToDTO)
                .toList();
    }
}
