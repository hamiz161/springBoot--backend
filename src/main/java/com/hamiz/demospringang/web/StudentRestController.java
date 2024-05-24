package com.hamiz.demospringang.web;

import com.hamiz.demospringang.Services.StudentService;
import com.hamiz.demospringang.entities.Payment;
import com.hamiz.demospringang.entities.Student;
import com.hamiz.demospringang.repository.PaymentRepository;
import com.hamiz.demospringang.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudent(){

        return  studentService.getAllStudent();
    }
    @GetMapping("/students/{id}")
    public Student getStudent( @PathVariable String id){
        return studentService.getStudentById(id).get();

    }
    @PutMapping("/delete/{id}")

    public void deleteStudent(@PathVariable String id){

        studentService.deleteUser(id);
    }
    @GetMapping("/studentsProgram")

    public List<Student> getStudentByProgramId(@RequestParam String program){
        return studentService.getStudentByProgramId(program);
    }

    @GetMapping("/studentsCode")

    public List<Student> getStudentByCode(@RequestParam String code){
        return  studentService.getStudentByCode(code);
    }



}
