package com.sahil.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements CoachInterface {
	
	// Define the private field
	private FortuneService2 fortuneService2;
	
	// Constructor for the Dependency injection
	@Autowired
	public TennisCoach(FortuneService2 theFortuneService2) {
		fortuneService2 = theFortuneService2;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice back hand for 30 minutes.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService2.getFortune() 
				+ "- The Constructor injection stuff";
	}

}
