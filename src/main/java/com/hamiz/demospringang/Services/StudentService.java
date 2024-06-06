package com.hamiz.demospringang.Services;

import com.hamiz.demospringang.Exeptions.RequestNotFoundExeption;
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


@Service

@AllArgsConstructor


public class StudentService {


    private StudentRepository studentRepository;

    private StudentMapper studentMapper;



    public List<StudentRepense> getAllStudent(){
        List<StudentRepense> studentRepense = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()){
            throw new RequestNotFoundExeption("No students found");
        }
        for (Student student : students) {
            studentRepense.add(studentMapper.toDto(student));
        }
        return studentRepense;

    }

    public StudentRepense getStudentById(Long id)  {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(studentMapper::toDto).orElseThrow(
                ()->new RequestNotFoundExeption("Student could not Found by id: "+id));


    }

    public List<StudentRepense> getStudentByProgramId(String programId){
        List<Student> students = studentRepository.findByProgramId(programId);
        List<StudentRepense> studentRepense = new ArrayList<>();

        if(students.isEmpty()){
            throw new RequestNotFoundExeption("No students found BY programId "+programId);
        }
        for (Student student : students) {
            studentRepense.add(studentMapper.toDto(student));
        }
        return studentRepense;
    }
    public List<Student> getStudentByCode(String code){

        return  studentRepository.findByCode(code);
    }
    public StudentRepense saveStudent(StudentRequest studentRequest){
        try {
            Student student = studentMapper.toEntity(studentRequest);
            Student saveStudent = studentRepository.save(student);
            return studentMapper.toDto(saveStudent);
        }catch(Exception e) {
            throw new RequestNotFoundExeption("Failed to save student",e);
        }
    }

    public void deleteStudent(Long id){
        if(studentRepository.existsById(id))
            studentRepository.deleteById(id);
        else{
            throw new RequestNotFoundExeption("Student could not delete by id: "+id);
        }


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
            try {
            Student saveStudent = studentRepository.save(student);

            return studentMapper.toDto(saveStudent);
            } catch (Exception e) {
                throw new RequestNotFoundExeption("Failed to update student with id " + id, e);
            }


        }else{
                throw new RequestNotFoundExeption("Student not found with id " + id);
        }


    }
}
