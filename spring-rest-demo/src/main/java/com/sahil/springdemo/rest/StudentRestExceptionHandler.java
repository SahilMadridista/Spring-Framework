package com.sahil.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// Add exception handling code here
	
	// Add an exception handler using @ExceptionHandler

	// StudentErrorResponse- Type of response body

	// StudentNotFoundException- Exception type to handle

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

	// Add another exception handler- To catch any exception

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

}
