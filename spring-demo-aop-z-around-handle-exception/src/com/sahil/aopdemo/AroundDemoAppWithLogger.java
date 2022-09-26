package com.sahil.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext; 
import com.sahil.aopdemo.service.TrafficFortuneService;

public class AroundDemoAppWithLogger {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundDemoAppWithLogger.class.getName());

	public static void main(String[] args) {
		
		
		// Read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("Main parogram- Around demo app");
		
		myLogger.info("The Traffic data is: " + theFortuneService.getFortune());
		
		myLogger.info("Finished");
		// Close the context
		context.close();
		
	}
	
}
