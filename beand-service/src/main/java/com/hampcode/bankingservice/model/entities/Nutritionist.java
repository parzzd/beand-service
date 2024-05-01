package com.hampcode.bankingservice.model.entities;

import java.sql.Blob;

import jakarta.persistence.Column;
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
@Table(name = "nutritionists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nutritionist{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;
    
    @Column(name = "owner_last_name", nullable = false)
    private String OwnerLastName;

    @Column(name = "owner_career", nullable = false)
    private String ownerCareer;
    
    /* @Column(name = "owner_cv", nullable = false)
    private Blob ownerCv; */
    
    /*  @ManyToOne
    @JoinColumn(name ="source_account_id",nullable = true)
    private User sourceUser; */


}
