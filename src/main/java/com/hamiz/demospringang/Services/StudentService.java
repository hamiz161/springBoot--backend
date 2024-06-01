package com.hamiz.demospringang.Services;

import com.hamiz.demospringang.dtos.StudentMapper;
import com.hamiz.demospringang.dtos.StudentRepense;
import com.hamiz.demospringang.dtos.StudentRequest;
import com.hamiz.demospringang.entities.Student;
import com.hamiz.demospringang.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public StudentRepense getStudentById(Long id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student =studentOptional.get();
            return studentMapper.toDto(student);
        }else{
            return null;
        }


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

    public void deleteStudent(Long id){
        if(studentRepository.existsById(id))
            studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id,Student newStudent) {
        Optional<Student> oldlStudent = studentRepository.findById(id);

        System.out.println(studentRepository.findById(id));

        if (oldlStudent.isPresent()) {

            Student st = oldlStudent.get();
           // st.setId(newStudent.getId());
            st.setFirstName(newStudent.getFirstName());
            st.setPhoto(newStudent.getPhoto());
            st.setCode(newStudent.getCode());
            st.setLastName(newStudent.getLastName());
            st.setProgramId(newStudent.getProgramId());
            return studentRepository.save(st);


        }else{
            throw new RuntimeException("Student not found with id " + id);
        }


    }
}
