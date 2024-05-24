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
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    private double amount;

    private PaymentType type;

    private PaymentStatus status;

    private  String file;
    @ManyToOne
    private Student student;



}
