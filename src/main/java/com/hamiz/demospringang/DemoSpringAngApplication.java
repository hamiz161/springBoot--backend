package com.hamiz.demospringang;
import com.hamiz.demospringang.entities.Student;
import com.hamiz.demospringang.repository.PaymentRepository;
import com.hamiz.demospringang.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class DemoSpringAngApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringAngApplication.class, args);

    }
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository){
//
//        return args -> {
//            Student student1 = new Student();
//            student1.setId("6");
//            student1.setCode("ift2125");
//            student1.setProgramId("12222");
//            student1.setLastName("mama");
//            student1.setFirstName("papa");
//
//            studentRepository.save(student1);
//
//
//
//
//        };
//    }



}
