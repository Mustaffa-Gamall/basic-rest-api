package com.example.Basic.API.App.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Student {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
   @Transient
	private Integer age;
	private LocalDate dob;
	
	public Student() {
		
	}

	public Student(Long id, String name, String email, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Student(String name, String email, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return Period.between(this.getDob(), LocalDate.now()).getYears();
	}

	// public void setAge(Integer age) {
	// 	this.age = age;
	// }

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Studnet [id=" + getId() + ", name=" + getName() + ", email=" + getEmail() + ", age=" + getAge() + ", dob=" + getDob() + "]";
	}
	
	 
}
