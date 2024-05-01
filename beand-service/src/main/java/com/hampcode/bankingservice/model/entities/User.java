package com.hampcode.bankingservice.model.entities;

import java.util.List;

<<<<<<< Updated upstream
import jakarta.persistence.CascadeType;
=======
>>>>>>> Stashed changes
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< Updated upstream
import jakarta.persistence.OneToMany;
=======
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
>>>>>>> Stashed changes
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;
    @Column(name = "owner_password", nullable = false)
    private String ownerPassword;
<<<<<<< Updated upstream
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRestriction> restrictions;
=======
    @ManyToMany
    @JoinTable(name = "user_ingredient",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> cannotConsumeIngredients;

>>>>>>> Stashed changes
}
