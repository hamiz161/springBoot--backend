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
    public List<Student> getStudentByCode(String code){

        return  studentRepository.findByCode(code);
    }
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(String id){
        if(studentRepository.existsById(id))
            studentRepository.deleteById(id);
    }

    public Student updateStudent(String id,Student newStudent) {
        Optional<Student> oldlStudent = studentRepository.findById(id);

        System.out.println(studentRepository.findById(id));

        if (oldlStudent.isPresent()) {

            Student student = oldlStudent.get();
            //student.setId(newStudent.getId());
            student.setFirstName(newStudent.getFirstName());
            student.setPhoto(newStudent.getPhoto());
            student.setCode(newStudent.getCode());
            student.setLastName(newStudent.getLastName());
            student.setProgramId(newStudent.getProgramId());


        }
        return studentRepository.save(newStudent);
    }
}
