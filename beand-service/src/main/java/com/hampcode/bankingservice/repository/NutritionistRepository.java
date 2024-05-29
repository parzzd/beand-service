package com.hampcode.bankingservice.repository;

import com.hampcode.bankingservice.model.entities.Nutritionist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionistRepository extends JpaRepository<Nutritionist, Long> {
}
