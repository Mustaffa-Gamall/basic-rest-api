package com.example.Basic.API.App.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

   private final StudentRepository studentRepository;

   @Autowired
   public StudentService(StudentRepository studentRepository) {
      this.studentRepository = studentRepository;
   }

   public List<Student> getStudents() {
      return studentRepository.findAll();
   }

   public void AddStudent(Student student) {
      Optional<Student> studentOptional = studentRepository.findStudenByEmail(student.getEmail());

      if(studentOptional.isPresent()) {
         throw new IllegalStateException("Email Exist");
      }

      studentRepository.save(student);
   }

   public void deleteStudentById(Long id) {
      boolean exist = studentRepository.existsById(id);
      if(!exist){
         throw new IllegalStateException("Student with id : "+id+" dose not exist");
      }
      studentRepository.deleteById(id);
   }

   public void updateStudentById(Long id, Student studentData) {
      Optional<Student> studentOptional = studentRepository.findById(id);
      
      if(!studentOptional.isPresent()){
         throw new IllegalStateException("Student with id : "+id+" dose not exist");
      }

      Student student = studentOptional.get();
      if(!studentData.getName().isEmpty()){
         student.setName(studentData.getName());
      }
      if(!studentData.getEmail().isEmpty()){
         student.setEmail(studentData.getEmail());
      }

      studentRepository.save(student);

   }
}
