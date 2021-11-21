package com.sahil.springdemo;

public class TrackCoach implements Coach {
	
	
	// Dependency field
	private FortuneService fortuneService;
	
	
	// Constructor
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run for 2 kilometers.";
	}
	
	@Override
	public String getDailyFortune() {
		return "Just do it buddy " + fortuneService.getFortune();
	}

}
