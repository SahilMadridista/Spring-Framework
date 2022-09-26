package com.sahil.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext; 
import com.sahil.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		
		// Read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("Main parogram- Around demo app");
		
		System.out.println("The Traffic data is: " + theFortuneService.getFortune());
		
		// Close the context
		context.close();
		
	}
	
}
