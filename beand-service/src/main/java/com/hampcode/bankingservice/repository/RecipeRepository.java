package com.hampcode.bankingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hampcode.bankingservice.model.entities.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r WHERE r.id =:userId")
    List<Recipe> findConsumableRecipesForUser(@Param("userId") Long userId);


}
