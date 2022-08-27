package com.sahil.mapping.demo;

import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;

public class MappingDemoApp {

	public static void main(String[] args) {
		
		// Object creation
		
		Instructor instructor = new Instructor("Toni", "Kroos", "tk8@gmail.com"); 
		
		InstructorDetail instructorDetail = new InstructorDetail("tkAcademy", "passing");
		
		// Associate the objects
		
		instructor.setInstructorDetail(instructorDetail);
		
		
	}
	
}
