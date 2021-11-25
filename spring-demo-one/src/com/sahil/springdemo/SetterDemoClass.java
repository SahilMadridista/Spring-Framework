package com.sahil.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoClass {

	public static void main(String[] args) {
		
		// Load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// Retrieve bean from Spring container
				
		CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);
				
		// Call methods on the bean
				
		System.out.println(theCoach.getDailyWorkout());
				
		System.out.println(theCoach.getDailyFortune());
				
		// Close the context
				
		context.close();

	}

}
