package com.sahil.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// Create a student object
		
		Student theStudent = new Student();
		
		// Add student object to the model
		
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	
	}
	
	// @ModelAttribute will bind the data from "student" to the Student object
	
	@RequestMapping("/processForm")
	public String process(@ModelAttribute("student") Student theStudent ) {
		
		// log the input data
		
		System.out.println("First name is: " + theStudent.getFirstName());

		System.out.println("Last name is: " + theStudent.getLastName());
		
		return "student-confirmation";
	}
	
	
}
