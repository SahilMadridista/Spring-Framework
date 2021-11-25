package com.sahil.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	public CricketCoach() {
		
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket coach: Inside setter method.");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do net practice.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
