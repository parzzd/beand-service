/* package com.hampcode.bankingservice.model.entities;

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
@Table(name = "notifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notifications_description", nullable = false)
    private String notificationDescription;

    @OneToOne
    @JoinColumn(name = "source_account_id", nullable = false)
    private User sourceUser;

    @JoinColumn(name = "source_publication_id", nullable = false)
    private Publication sourcePublication;
}
 */