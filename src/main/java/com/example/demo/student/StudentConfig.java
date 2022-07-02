package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository){
        return args -> {
            Student fernando = new Student(
                    "Fernando Revilla",
                    LocalDate.of(2002, AUGUST, 19),
                    "fernando@gmail.com"
            );

            Student diego = new Student(
                    "Diego Gutarra",
                    LocalDate.of(2002, APRIL, 19),
                    "diego@gmail.com"
            );

            studentRepository.saveAll(
                    Arrays.asList(
                            fernando,
                            diego
                    )
            );
        };
    }

}
