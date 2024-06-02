package com.hamiz.demospringang.Services;

import com.hamiz.demospringang.dtos.StudentMapper;
import com.hamiz.demospringang.dtos.StudentRepense;
import com.hamiz.demospringang.dtos.StudentRequest;
import com.hamiz.demospringang.entities.Student;
import com.hamiz.demospringang.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor


public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public List<StudentRepense> getAllStudent(){
        List<StudentRepense> studentRepense = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            studentRepense.add(studentMapper.toDto(student));
        }
        return studentRepense;


    }

    public StudentRepense getStudentById(Long id)  {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(studentMapper::toDto).orElseThrow(
                ()->new RuntimeException(String.format("notFound %s",id)));


    }


    public List<Student> getStudentByProgramId(String programId){


        return  studentRepository.findByProgramId(programId);
    }
    public List<Student> getStudentByCode(String code){

        return  studentRepository.findByCode(code);
    }
    public StudentRepense saveStudent(StudentRequest studentRequest){
        Student student = studentMapper.toEntity(studentRequest);
        Student saveStudent = studentRepository.save(student);


        return studentMapper.toDto(saveStudent) ;
    }

    public void deleteStudent(Long id){
        if(studentRepository.existsById(id))
            studentRepository.deleteById(id);
    }

    public StudentRepense updateStudent(Long id,StudentRequest studentRequest) {
        Optional<Student> oldlStudent = studentRepository.findById(id);

        if (oldlStudent.isPresent()) {
            Student student = oldlStudent.get();
            student.setFirstName(studentRequest.getFirstName());
            student.setLastName(studentRequest.getLastName());
            student.setProgramId(studentRequest.getProgramId());
            student.setCode(studentRequest.getCode());
            student.setPhoto(studentRequest.getPhoto());
            Student saveStudent = studentRepository.save(student);

            return studentMapper.toDto(saveStudent);


        }else{
            throw new RuntimeException("Student not found with id " + id);
        }


    }
}
