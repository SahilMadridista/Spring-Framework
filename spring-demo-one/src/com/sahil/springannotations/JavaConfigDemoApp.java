package com.sahil.springannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sahil.springannotations.CoachInterface;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		
				AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext(SportConfig.class);
						
				// Retrieve bean from Spring container
						  
				CoachInterface theCoach = 
						context.getBean("swimCoach",CoachInterface.class);
						
				// Call methods on the bean
						
				System.out.println(theCoach.getDailyWorkout());
				
				System.out.println(theCoach.getDailyFortune());
				
				// Close the context
						
				context.close();
		
	}

}
