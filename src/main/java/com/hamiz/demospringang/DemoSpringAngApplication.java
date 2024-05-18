package com.hamiz.demospringang;

import com.hamiz.demospringang.entities.Payment;
import com.hamiz.demospringang.entities.PaymentType;
import com.hamiz.demospringang.entities.Student;
import com.hamiz.demospringang.entities.PaymentStatus;
import com.hamiz.demospringang.repository.PaymentRepository;
import com.hamiz.demospringang.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class DemoSpringAngApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringAngApplication.class, args);
        System.out.println("adas");
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository){

        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("hamza").lastName("Gue")
                    .code("123456").programId("ift2105").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("oussam").lastName("khencvhla")
                    .code("1201").programId("ift2205").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("ahmed").lastName("bob")
                    .code("505").programId("ift1015").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("najat").lastName("manou")
                    .code("4023").programId("ift2015").build());

            PaymentType [] paymentTypes = PaymentType.values();

            studentRepository.findAll().forEach(student -> {


                for (int i = 0; i < 5; i++) {
                    Random ran = new Random();
                    int index = ran.nextInt(paymentTypes.length);
                    Payment payment = Payment.builder().amount(1000+(int)(Math.random()+2000))
                            .type(paymentTypes[index]).status(PaymentStatus.CREATED).date(LocalDate.now()).
                            student(student).
                            build();
                    paymentRepository.save(payment);


                }
            });
        };
    }

}
