package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// Add an exception handler for Customer not found exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleExc(CustomerException exc){
		
		// Create CustomerErrorResponse
		
		CustomerErrorResponse err = new CustomerErrorResponse();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(exc.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		// return the ResponseEntity
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	
	// Add an exception handler for any exception
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleExc(Exception e){
		
		// Create CustomerErrorResponse
		
		CustomerErrorResponse err = new CustomerErrorResponse();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		// return the ResponseEntity
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
		
		
	}
	
}
