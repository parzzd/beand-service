package com.hampcode.bankingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hampcode.bankingservice.model.entities.Recipe;


public interface RecipeRepository extends JpaRepository<Recipe,Long>{
    @Query("SELECT r from Recipe r where r.recipeName=:recipeName")
    Recipe findByRecipeName(@Param("recipeName")String recipeName);
    
    
}



