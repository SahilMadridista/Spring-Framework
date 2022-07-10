package com.sahil.springdemo;

public class BaseballCoach implements Coach {
	
	// Define a private field for the dependency
	private FortuneService fortuneService;
	
	// Define a constructor for DI
	public BaseballCoach(HappyFortuneService theFortuneService) {
		fortuneService =  theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting practice.";
	}

	@Override
	public String getDailyFortune() {
		// Use the fortuneService to get a fortune
		return fortuneService.getFortune();
	}

}
