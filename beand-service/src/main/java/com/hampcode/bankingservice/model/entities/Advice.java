package com.hampcode.bankingservice.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "advices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "nutritionist_id", nullable = false)
    private Nutritionist nutritionist;

    public void setMessage(String string) {
         throw new UnsupportedOperationException("Unimplemented method 'setMessage'");
    }
}
