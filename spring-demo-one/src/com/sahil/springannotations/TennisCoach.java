package com.sahil.springannotations;

import org.springframework.stereotype.Component;

@Component("theSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice back hand for 30 minutes.";
	}

}
