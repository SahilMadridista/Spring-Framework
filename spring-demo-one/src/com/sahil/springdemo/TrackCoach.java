package com.sahil.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneSerice;
	
	public TrackCoach(FortuneService fortuneSerice) {
		this.fortuneSerice = fortuneSerice;
	}
	
	public TrackCoach() {
		
	}

	@Override
	public String getDailyWorkout() {
		return "Run for 2 kilometers.";
	}

	@Override
	public String getDailyFortune() {
		return "Track coach - " + fortuneSerice.getFortune();
	}

	
}
