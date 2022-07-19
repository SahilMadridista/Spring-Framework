package com.sahil.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
				
		// Retrieve bean from Spring container
				  
		CoachInterface theCoach = 
				context.getBean("tennisCoach",CoachInterface.class);
				
		// Call methods on the bean
				
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		// Close the context
				
		context.close();
		

	}

}
