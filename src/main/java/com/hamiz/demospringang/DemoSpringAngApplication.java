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

    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository){

        return args -> {
            Student student1 = new Student();
            student1.setId("1");
            student1.setCode("12345");
            student1.setProgramId("1236544");
            student1.setLastName("guerabli");
            student1.setFirstName("hamza");

            studentRepository.save(student1);

            Student student2 = new Student();
            student2.setId("2");
            student2.setCode("0000");
            student2.setProgramId("151515");
            student2.setLastName("lassice");
            student2.setFirstName("oussama");

            studentRepository.save(student2);

            Student s3 = new Student();
            s3.setId("3");
            s3.setCode("adqdw");
            s3.setProgramId("1236544");
            s3.setLastName("hocine");
            s3.setFirstName("hamza");
            studentRepository.save(s3);


        };
    }



}
