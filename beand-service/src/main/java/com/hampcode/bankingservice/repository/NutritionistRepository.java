package com.hampcode.bankingservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hampcode.bankingservice.model.entities.Nutritionist;

public interface NutritionistRepository extends JpaRepository<Nutritionist,Long>{
   //* */  @Query("SELECT t FROM ")
   //* */  Optional<Nutritionist> findById(Long id);
}
