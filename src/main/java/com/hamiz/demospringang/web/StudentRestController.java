package com.hamiz.demospringang.web;

import com.hamiz.demospringang.Services.StudentService;
import com.hamiz.demospringang.dtos.StudentRepense;
import com.hamiz.demospringang.dtos.StudentRequest;
import com.hamiz.demospringang.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public  ResponseEntity<List<StudentRepense>>getAllStudent(){

        List<StudentRepense> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentRepense> getStudentById(@PathVariable Long id) {
        StudentRepense student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping ("/students/{id}")

    public void deleteStudent(@PathVariable Long id){

        studentService.deleteStudent(id);
    }
    @GetMapping("/studentsProgram")

    public List<Student> getStudentByProgramId(@RequestParam String program){
        return studentService.getStudentByProgramId(program);
    }

    @GetMapping("/studentsCode")

    public List<Student> getStudentByCode(@RequestParam String code){

        return  studentService.getStudentByCode(code);
    }
    @PostMapping("/students")

    public ResponseEntity<StudentRepense>  createStudent(@RequestBody StudentRequest studentRequest){
        StudentRepense savedStudent = studentService.saveStudent(studentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);

    }

    @PutMapping("/students/{id}")

    public ResponseEntity<StudentRepense> updateStudent(@PathVariable Long id,@RequestBody StudentRequest studentRequest){
        StudentRepense savedStudent = studentService.updateStudent(id,studentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }


}
