package com.hampcode.bankingservice.controller;

import com.hampcode.bankingservice.model.dto.AdviceRequestDTO;
import com.hampcode.bankingservice.model.dto.AdviceResponseDTO;
import com.hampcode.bankingservice.model.entities.Advice;
import com.hampcode.bankingservice.model.entities.Nutritionist;
import com.hampcode.bankingservice.repository.AdviceRepository;
import com.hampcode.bankingservice.repository.NutritionistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdviceControllerIntegration {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AdviceRepository adviceRepository;

    @Autowired
    private NutritionistRepository nutritionistRepository;

    private Nutritionist nutritionist;

    @BeforeEach
    public void setUp() {
        adviceRepository.deleteAll();
        nutritionistRepository.deleteAll();

        nutritionist = new Nutritionist();
        nutritionist.setOwnerName("John");
        nutritionist.setOwnerLastName("Doe");
        nutritionist.setOwnerCareer("Nutritionist");
        nutritionist = nutritionistRepository.save(nutritionist);
    }

    @Test
    public void testCreateAdvice() {
        AdviceRequestDTO requestDTO = new AdviceRequestDTO("Eat more vegetables", null, nutritionist.getId());

        ResponseEntity<AdviceResponseDTO> response = restTemplate.postForEntity("/advices", requestDTO, AdviceResponseDTO.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        AdviceResponseDTO advice = response.getBody();
        assertNotNull(advice);
        assertEquals("Eat more vegetables", advice.getMessage());
        assertEquals(nutritionist.getId(), advice.getNutritionistId());
    }

    @Test
    public void testGetAllAdvices() {
        Advice advice1 = new Advice();
        advice1.setMessage("Eat more vegetables");
        advice1.setNutritionist(nutritionist);
        adviceRepository.save(advice1);

        Advice advice2 = new Advice();
        advice2.setMessage("Drink more water");
        advice2.setNutritionist(nutritionist);
        adviceRepository.save(advice2);

        ResponseEntity<AdviceResponseDTO[]> response = restTemplate.getForEntity("/advices", AdviceResponseDTO[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        AdviceResponseDTO[] advices = response.getBody();
        assertNotNull(advices);
        assertEquals(2, advices.length);
    }
}
