package com.hamiz.demospringang.repository;

import com.hamiz.demospringang.entities.Payment;
import com.hamiz.demospringang.entities.PaymentType;
import com.hamiz.demospringang.entities.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository <Payment,Long> {

    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);

    List<Payment> findByType(PaymentType type);
}
