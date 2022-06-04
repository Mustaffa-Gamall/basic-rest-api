package com.example.Basic.API.App.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

   @Bean
   CommandLineRunner commandLineRunner(StudentRepository repository) {
      return args -> {
         Student s1 = new Student("test 1", "test1@test.com", 21 , LocalDate.of(2000, Month.MARCH, 20 ) );
         Student s2 = new Student("test 2", "test2@test.com", 24 , LocalDate.of(2001, Month.MARCH, 20 ) );
      
         repository.saveAll(List.of(s1, s2));
      };
   }
}