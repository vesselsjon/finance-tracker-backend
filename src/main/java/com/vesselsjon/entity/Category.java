package com.vesselsjon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private BigDecimal budgetLimit;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /*
     TODO: @OneToMany(mappedBy = "category")
     private List<Transaction> transactions;
    */
}
