package com.hampcode.bankingservice.model.entities;

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
@Table(name = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(name = "owner_name", nullable = false)
    private String ownerName;
   
    @Column(name = "owner_last_name", nullable = false)
    private String ownerLastName;

    @Column(name = "owner_age", nullable = false)
    private int ownerAge;
    @Column(name = "owner_weight", nullable = false)
    private float ownerWeight;
    @Column(name = "owner_height", nullable = false)
    private float ownerHeight;

    @ManyToOne
    @JoinColumn(name ="source_account_id",nullable = false)
    private User sourceUser;
    
    
}