package com.sahil.springdemo;

public class BaseballCoach implements Coach {
	
	// Bean id = "myCoach"
	
	// Define a private field for the dependency
	
	private FortuneService fortuneService;
	
	// Define the constructor
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		return "Do 100 push ups.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	


}
