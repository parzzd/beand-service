package com.hampcode.bankingservice.services;

import com.hampcode.bankingservice.exceptions.ResourceNotFoundException;
import com.hampcode.bankingservice.mapper.AdviceMapper;
import com.hampcode.bankingservice.model.dto.AdviceRequestDTO;
import com.hampcode.bankingservice.model.dto.AdviceResponseDTO;
import com.hampcode.bankingservice.model.entities.Advice;
import com.hampcode.bankingservice.model.entities.Nutritionist;
import com.hampcode.bankingservice.repository.AdviceRepository;
import com.hampcode.bankingservice.repository.NutritionistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdviceServiceTest {

    @Mock
    private AdviceRepository adviceRepository;

    @Mock
    private NutritionistRepository nutritionistRepository;

    @Mock
    private AdviceMapper adviceMapper;

    @InjectMocks
    private AdviceService adviceService;

    @Test
    public void testCreateAdvice() {
        AdviceRequestDTO requestDTO = new AdviceRequestDTO("Eat more vegetables", null, 1L);
        Nutritionist nutritionist = new Nutritionist();
        Advice advice = new Advice();
        AdviceResponseDTO responseDTO = new AdviceResponseDTO(1L, "Eat more vegetables", null, 1L);

        when(nutritionistRepository.findById(1L)).thenReturn(Optional.of(nutritionist));
        when(adviceMapper.convertToEntity(requestDTO)).thenReturn(advice);
        when(adviceRepository.save(advice)).thenReturn(advice);
        when(adviceMapper.convertToDTO(advice)).thenReturn(responseDTO);

        AdviceResponseDTO result = adviceService.createAdvice(requestDTO);

        assertEquals(responseDTO, result);
        verify(adviceRepository).save(advice);
    }

    @Test
    public void testCreateAdvice_NutritionistNotFound() {
        AdviceRequestDTO requestDTO = new AdviceRequestDTO("Eat more vegetables", null, 1L);

        when(nutritionistRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            adviceService.createAdvice(requestDTO);
        });
    }

    @Test
    public void testGetAllAdvices() {
        Advice advice1 = new Advice();
        Advice advice2 = new Advice();
        List<Advice> advices = List.of(advice1, advice2);
        AdviceResponseDTO responseDTO1 = new AdviceResponseDTO(1L, "Eat more vegetables", null, 1L);
        AdviceResponseDTO responseDTO2 = new AdviceResponseDTO(2L, "Drink more water", null, 1L);
        List<AdviceResponseDTO> responseDTOs = List.of(responseDTO1, responseDTO2);

        when(adviceRepository.findAll()).thenReturn(advices);
        when(adviceMapper.convertToListDTO(advices)).thenReturn(responseDTOs);

        List<AdviceResponseDTO> result = adviceService.getAllAdvices();

        assertEquals(responseDTOs, result);
    }
}

