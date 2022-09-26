package com.sahil.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext; 
import com.sahil.aopdemo.service.TrafficFortuneService;

public class AroundHandleExcDemoApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundHandleExcDemoApp.class.getName());

	public static void main(String[] args) {
		
		
		// Read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("Main parogram- Around demo app");
		
		boolean flag = true;
		
		String data = theFortuneService.getFortune(flag);
		
		myLogger.info("The Traffic data is: " + data);
		
		myLogger.info("Finished");
		// Close the context
		context.close();
		
	}
	
}
