package com.hampcode.bankingservice.repository;

import com.hampcode.bankingservice.model.entities.Advice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdviceRepository extends JpaRepository<Advice, Long> {
    List<Advice> findByNutritionistId(Long nutritionistId);
}
