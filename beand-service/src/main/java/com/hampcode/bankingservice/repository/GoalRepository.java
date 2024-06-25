package com.hampcode.bankingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hampcode.bankingservice.model.entities.Goal;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUserId(Long userId); // Método para obtener metas por usuario
}