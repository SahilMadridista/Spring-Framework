package com.sahil.aopdemo.service;

import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		// Simulate a delay
		
		try {
			
			TimeUnit.SECONDS.sleep(4);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		// Return a fortune
		
		return "High traffic in the morning";
		
	}
	
}
