package com.sahil.springannotations;

public class SwimCoach implements CoachInterface {

	private FortuneService2 fortuneService2;
	
	public SwimCoach(FortuneService2 theFortuneService2) {
		fortuneService2 = theFortuneService2;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Swim for 20 mins as a warm up.";
	}

	@Override
	public String getDailyFortune() { 
		return "SwimCoach " + fortuneService2.getFortune();
	}

}
