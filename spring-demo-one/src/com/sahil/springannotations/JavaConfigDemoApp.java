package com.sahil.springannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sahil.springannotations.CoachInterface;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		
				AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext(SportConfig.class);
						
				// Retrieve bean from Spring container
						  
				SwimCoach theCoach = 
						context.getBean("swimCoach",SwimCoach.class);
						
				// Call methods on the bean
						
				System.out.println(theCoach.getDailyWorkout());
				
				System.out.println(theCoach.getDailyFortune());
				
				System.out.println(theCoach.getEmail());
				
				System.out.println(theCoach.getTeam());
				
				// Close the context
						
				context.close();
		
	}

}
