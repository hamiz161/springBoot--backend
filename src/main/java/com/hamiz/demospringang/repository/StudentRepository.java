package com.hamiz.demospringang.repository;

import com.hamiz.demospringang.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {

    Student findBytCode(String code);
    List<Student> findByProgramId(String programId);


}
