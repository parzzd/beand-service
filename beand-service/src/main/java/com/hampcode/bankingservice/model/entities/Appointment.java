package com.hampcode.bankingservice.model.entities;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(name = "owner_name", nullable = false)
    private LocalDateTime createdDate;
   
    @Column(name = "owner_last_name", nullable = false)
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name ="source_account_id",nullable = false)
    private User sourceUser;
    
}