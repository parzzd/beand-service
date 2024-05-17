package com.hampcode.bankingservice.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hampcode.bankingservice.model.entities.Ingredient;



public interface IngredientRepository extends JpaRepository<Ingredient,Long>{
    @Query("SELECT i from Ingredient i WHERE i.ingredientName = :ingredientName")
    Set<Ingredient> findByIngredientNameList(@Param("ingredientName") String ingredientName);
    
    @Query("SELECT i from Ingredient i WHERE i.ingredientName = :ingredientName")
    Ingredient findByIngredientName(String ingredientName);
    
} 