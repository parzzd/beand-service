package com.hampcode.bankingservice.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_account", nullable = false)
    private String typeAccount;
    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "update_at")
    private LocalDate updatedAt;
    @Column(name = "password", nullable = false)
    private String password;
}
