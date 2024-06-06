package com.hamiz.demospringang.Services;


import com.hamiz.demospringang.Exeptions.RequestNotFoundExeption;
import com.hamiz.demospringang.dtos.PaymentMapper;
import com.hamiz.demospringang.dtos.PaymentRepense;
import com.hamiz.demospringang.dtos.PaymentRequest;
import com.hamiz.demospringang.entities.Payment;
import com.hamiz.demospringang.entities.Student;
import com.hamiz.demospringang.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentService {

    PaymentRepository paymentRepository;


    public List<PaymentRepense> getAllPayments(){
        List<PaymentRepense> paymentsRepense = new ArrayList<>();
        List<Payment> payments = paymentRepository.findAll();

        if(payments.isEmpty()){
            throw new RequestNotFoundExeption("No payments found !");
        }else {
            for (Payment payment : payments) {
                paymentsRepense.add(PaymentMapper.INSTANCE.toDto(payment));
            }
            return paymentsRepense;
        }
    }

    public PaymentRepense createPayment(PaymentRequest paymentRequest){
        try {
            Payment payment = PaymentMapper.INSTANCE.toEntity(paymentRequest);//studentMapper.toEntity(paymentRequest);
             paymentRepository.save(payment);
            return PaymentMapper.INSTANCE.toDto(payment);
        }catch(Exception e) {
            throw new RequestNotFoundExeption("Failed to save Payment",e);
        }

    }



}
