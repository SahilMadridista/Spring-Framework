package com.sahil.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemo {

	public static void main(String[] args) {
		
		// Load spring configuration file
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
		
		// Retrieve bean from spring container
		
		CoachInterface theCoach = 
				context.getBean("tennisCoach",CoachInterface.class);
		
		CoachInterface theCoach2 = 
				context.getBean("tennisCoach",CoachInterface.class);
		
		System.out.println(theCoach == theCoach2);
		
		
		context.close();
	}
	
}
