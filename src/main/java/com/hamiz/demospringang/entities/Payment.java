package com.hamiz.demospringang.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    private double amount;


    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private  String file;
    @ManyToOne
    private Student student;



}
