package com.hamiz.demospringang.web;


import com.hamiz.demospringang.Services.PaymentService;
import com.hamiz.demospringang.dtos.PaymentRepense;
import com.hamiz.demospringang.dtos.PaymentRequest;
import com.hamiz.demospringang.dtos.StudentRepense;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor

@RestController

@RequestMapping

public class PaymentRestController {

    PaymentService paymentService;


    @GetMapping("/payments")

    public ResponseEntity<List<PaymentRepense>> getAllStudents(){
        List<PaymentRepense> paymentRepenses = paymentService.getAllPayments();
        return ResponseEntity.ok(paymentRepenses);

    }

    @PostMapping("/payments")

    public ResponseEntity<PaymentRepense> createPayment(@RequestBody PaymentRequest paymentRequest){
        PaymentRepense paymentRepense = paymentService.createPayment(paymentRequest);
        return ResponseEntity.ok(paymentRepense);
    }
}
