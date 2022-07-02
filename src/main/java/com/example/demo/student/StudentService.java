package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        boolean existsWithEmail = studentRepository.findStudentByEmail(student.getEmail()).isPresent();

        if (existsWithEmail) throw  new IllegalStateException("email taken");

        return studentRepository.save(student);
    }
}
