package com.hamiz.demospringang.dtos;

import com.hamiz.demospringang.entities.PaymentStatus;
import com.hamiz.demospringang.entities.PaymentType;
import com.hamiz.demospringang.entities.Student;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;


@Data
public class PaymentRepense {

    private Long id;
    private LocalDate date;

    private double amount;

    private PaymentType type;

    private PaymentStatus status;

    private  String file;
    @ManyToOne
    private Student student;
}
