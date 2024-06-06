package com.hamiz.demospringang.dtos;


import com.hamiz.demospringang.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment toEntity(PaymentRequest paymentRequest);
    PaymentRepense toDto(Payment payment);
}
