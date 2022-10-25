package com.sahil.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	private List<Student> myList;
	
	// Define @PostConstruct to load the student data... only once
	
	@PostConstruct
	public void loadData() {
		
		myList = new ArrayList<Student>();
		
		myList.add(new Student("Karim", "Benzema"));
		myList.add(new Student("Luka", "Modric"));
		myList.add(new Student("Federico", "valverde"));
		myList.add(new Student("Toni", "Kroos"));
		myList.add(new Student("Dani","Carvajal"));
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return myList;
	}
	
	
	// Define endpoint for "/students/{studentId}"- Return student at index
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// Just index into the list... keeping it simple for now
		
		return myList.get(studentId);
		
	}
	
	
}
