package com.hampcode.bankingservice.model.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "recipes")
@AllArgsConstructor
@NoArgsConstructor

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "recipe_name",nullable = false)
    private String recipeName;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name="photo",nullable = false)
    private String photo;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST})
    @JoinTable(name = "ingredient_map",joinColumns = @JoinColumn(name="recipe_id"),inverseJoinColumns=@JoinColumn(name="ingredient_id"))
    private Set<Ingredient> ingredients=new HashSet<>();


    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);    }
}
