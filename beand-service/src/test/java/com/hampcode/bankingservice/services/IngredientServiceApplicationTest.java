package com.hampcode.bankingservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hampcode.bankingservice.mapper.IngredientMapper;
import com.hampcode.bankingservice.model.dto.IngredientResponseDTO;
import com.hampcode.bankingservice.model.entities.Ingredient;
import com.hampcode.bankingservice.repository.IngredientRepository;
import org.mockito.InjectMocks;

@SpringBootTest
public class IngredientServiceApplicationTest {

    @Mock
    private IngredientRepository ingredientRepository;

    @Mock
    private IngredientMapper ingredientMapper;

    @InjectMocks
    private IngredientService ingredientService;


    @Test
    public void testGetAllIngredients() {
        // Arrange
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);
        ingredient1.setIngredientName("tomate");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);
        ingredient2.setIngredientName("cebolla");

        List<Ingredient> ingredientList = Arrays.asList(ingredient1, ingredient2);

        when(ingredientRepository.findAll()).thenReturn(ingredientList);

        IngredientResponseDTO responseDTO1 = new IngredientResponseDTO();
        responseDTO1.setId(ingredient1.getId());
        responseDTO1.setIngredientName(ingredient1.getIngredientName());

        IngredientResponseDTO responseDTO2 = new IngredientResponseDTO();
        responseDTO2.setId(ingredient2.getId());
        responseDTO2.setIngredientName(ingredient2.getIngredientName());

        List<IngredientResponseDTO> expectedResponse = Arrays.asList(responseDTO1, responseDTO2);
        when(ingredientMapper.convertToIngredientListDTO(ingredientList)).thenReturn(expectedResponse);

        List<IngredientResponseDTO> result = ingredientService.getAllIngredients();

        assertNotNull(result);
        assertEquals(expectedResponse.size(), result.size());
        assertEquals(expectedResponse, result);

        verify(ingredientRepository, times(1)).findAll();
        verify(ingredientMapper, times(1)).convertToIngredientListDTO(ingredientList);
    }
}
