package com.hampcode.bankingservice.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "resources")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private Long id;
    @Column(name = "resource_name")
    private String resourceName;
    @Column(name = "description")
    private String resourceDescription;
    @Column(name="photo",nullable = false)
    private String photo;
}
