package com.hampcode.bankingservice.model.entities;


import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(name = "plan_name", nullable = false)
    private String planName;
   
    @Column(name = "plan_price", nullable = false)
    private int planPrice;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "due_date", nullable = false)
    private LocalDateTime dueDate;
    
    @OneToOne
    @JoinColumn(name ="source_account_id",nullable = false)
    private User sourceUser;


}
