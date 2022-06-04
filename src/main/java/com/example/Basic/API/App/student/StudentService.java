package com.example.Basic.API.App.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	public List<Student> getStudents()
	   {
	      return List.of(
	    		  new Student(1L, "Mustafa", "Mustafa@gmai.com", 26, LocalDate.of(1996, Month.MARCH, 26))
	    		  );
	   }
}
