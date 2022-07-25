package com.sahil.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements CoachInterface {
	
	// Define the private field
	
	@Autowired
	@Qualifier("databaseFortuneService")
	private FortuneService2 fortuneService2;
	
	public TennisCoach() {
		System.out.println("---Tennis coach- No arg constructor---.");
	}
	
//	// Constructor for the Dependency injection
//	@Autowired
//	public TennisCoach(FortuneService2 theFortuneService2) {
//		fortuneService2 = theFortuneService2;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice back hand for 30 minutes.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService2.getFortune() 
				+ "- The Constructor injection stuff";
	}


//	@Autowired
//	public void setFortuneService2(FortuneService2 fortuneService2) {
//		System.out.println("---Tennis coach- setter method---.");
//		this.fortuneService2 = fortuneService2;
//	}
	
	

}
