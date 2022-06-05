package com.example.Basic.API.App.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> getStudents() {
	   return studentService.getStudents();
	}

   @PostMapping
   public void AddStudent(@RequestBody Student student) {
      studentService.AddStudent(student);
   }

   @PutMapping(path = "{studentId}")
   public void updateStudent(@PathVariable("studentId") Long id, @RequestBody Student studentData) {
      studentService.updateStudentById(id, studentData);
   }

   @DeleteMapping(path = "{studentId}")
   public void deleteStudent(@PathVariable("studentId") Long id) {
      studentService.deleteStudentById(id);
   }
}
