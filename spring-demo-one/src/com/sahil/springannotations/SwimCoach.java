package com.sahil.springannotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements CoachInterface {

	private FortuneService2 fortuneService2;
	
	@Value("${foo.email}")
	String email;
	
	@Value("${foo.team}")
	String team;
	
	
	
	public SwimCoach(FortuneService2 theFortuneService2) {
		fortuneService2 = theFortuneService2;
	}
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}


	@Override
	public String getDailyWorkout() {
		return "Swim for 20 mins as a warm up ";
	}

	@Override
	public String getDailyFortune() { 
		return "SwimCoach" + fortuneService2.getFortune();
	}

}
