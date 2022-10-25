package com.sahil.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		myList.add(new Student("Dani", "Carvajal"));

	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return myList;
	}

	// Define endpoint for "/students/{studentId}"- Return student at index

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// Just index into the list... keeping it simple for now

		// Check if the student id is valid

		if ((studentId >= myList.size()) || studentId < 0) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}

		return myList.get(studentId);

	}

	// Add an exception handler using @ExceptionHandler

	// StudentErrorResponse- Type of response body

	// StudentNotFoundException- Exception type to handle

	/*
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

		// Create a studentErrorResponse

		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// Return responseEntity

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	*/

	// Add another exception handler- To catch any exception

	/*
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {

		// Create a studentErrorResponse

		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// Return responseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
	
	*/

}
