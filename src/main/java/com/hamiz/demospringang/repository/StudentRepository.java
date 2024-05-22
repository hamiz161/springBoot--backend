package com.hamiz.demospringang.repository;

import com.hamiz.demospringang.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {

    List <Student> findByProgramId(String programId);

}
