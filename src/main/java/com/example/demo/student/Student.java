package com.example.demo.student;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;

    @Transient
    private Integer age;
    private LocalDate birthDay;
    private String email;

    public Student(){

    }

    public Student(String name, LocalDate birthDay, String email) {
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
    }

    public Integer getAge(){
        return Period.between(this.birthDay, LocalDate.now()).getYears();
    }
}
