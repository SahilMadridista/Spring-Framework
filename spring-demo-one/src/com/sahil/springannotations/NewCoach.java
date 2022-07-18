package com.sahil.springannotations;

import org.springframework.stereotype.Component;

@Component
public class NewCoach implements CoachInterface {

	@Override
	public String getDailyWorkout() {
		return "Do something.";
	}

}
