package com.hamiz.demospringang.web;

import com.hamiz.demospringang.Services.StudentService;
import com.hamiz.demospringang.dtos.StudentRepense;
import com.hamiz.demospringang.dtos.StudentRequest;
import com.hamiz.demospringang.entities.Student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;



import java.util.List;

@Controller
@AllArgsConstructor
public class StudentControlergraphQl {


    private StudentService studentService;

    @QueryMapping
    public List<StudentRepense> getAllStudent(){

        return studentService.getAllStudent();

    }
    @QueryMapping
    StudentRepense getStudent(@Argument  long id){
        return studentService.getStudentById(id);
    }
    @QueryMapping
    public List<StudentRepense>  getStudentByProgramId(@Argument String programId){
        return studentService.getStudentByProgramId(programId);
    }
    @QueryMapping
    public List<Student> getStudentByCode(@Argument String code){

        return  studentService.getStudentByCode(code);
    }
    @QueryMapping
    public void deleteStudent(@Argument Long id){

        studentService.deleteStudent(id);
    }
    @MutationMapping
    public StudentRepense createStudent(@Argument  StudentRequest studentRequest){
        return studentService.saveStudent(studentRequest);

    }
    @MutationMapping
    public StudentRepense updateStudent(@Argument  Long id, @Argument  StudentRequest studentRequest){
        return studentService.updateStudent(id,studentRequest);

    }


}
