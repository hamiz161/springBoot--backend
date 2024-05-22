package com.hamiz.demospringang.Services;

import com.hamiz.demospringang.entities.Student;
import com.hamiz.demospringang.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id){
        return studentRepository.findById(id);
    }
    public List<Student> getStudentByProgramId(String programId){
        return  studentRepository.findByProgramId(programId);
    }

    public void deleteUser(String id){
        if(studentRepository.existsById(id))
            studentRepository.deleteById(id);
    }
}
