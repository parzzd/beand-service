package com.hampcode.bankingservice.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mealplans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="person_id",nullable = false)
    private Person personUser;
    @ManyToOne
    @JoinColumn(name ="day_id",nullable = false)
    private Date day;
    @ManyToOne
    @JoinColumn(name ="recipe_id",nullable = false)
    private Recipe recipe;
}
