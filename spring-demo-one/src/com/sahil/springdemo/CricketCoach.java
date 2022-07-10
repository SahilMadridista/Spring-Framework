package com.sahil.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// Define new fields to inject literal values
	private String emailAddress;
	private String team;

	public CricketCoach() {
		System.out.println("No argument constructor- CricketCoach");
	}
	
	// Setter method for setter injection
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setFortuneService setter method- CricketCoach");
		this.fortuneService = fortuneService;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Inside setEmailAddresse setter method- CricketCoach");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("Inside setTeam setter method- CricketCoach");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		return "Net practice for 30 minutes- CricketCoach";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune() + " CricketCoach";
	}

}
