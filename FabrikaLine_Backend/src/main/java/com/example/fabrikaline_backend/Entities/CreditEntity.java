package com.example.fabrikaline_backend.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class CreditEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account creditorAccount;

    @ManyToOne
    private Account debtorAccount;

    private double amount;
    private double interestRate;
    private LocalDate startDate;
    private LocalDate endDate;

}
