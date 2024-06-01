package com.hamiz.demospringang.dtos;


import com.hamiz.demospringang.entities.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

  public Student toEntity(StudentRequest studentRequest){
      Student student = new Student();
      student.setFirstName(studentRequest.getFirstName());
      student.setLastName(studentRequest.getLastName());
      student.setProgramId(studentRequest.getProgramId());
      student.setCode(studentRequest.getCode());
      student.setPhoto(studentRequest.getPhoto());

      return student;
  }
    public StudentRepense toDto(Student student ){
        StudentRepense studentRepense = new StudentRepense();
        studentRepense.setId(student.getId());
        studentRepense.setFirstName(student.getFirstName());
        studentRepense.setLastName(student.getLastName());
        studentRepense.setProgramId(student.getProgramId());
        studentRepense.setCode(student.getCode());
        studentRepense.setPhoto(student.getPhoto());

        return studentRepense;
    }
}
