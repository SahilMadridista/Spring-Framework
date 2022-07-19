package com.sahil.springannotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService2 {

	// Create an array of strings
	
	private String[] data = {
			"Hello, this is first fortune",
			"Hello, this is second fortune",
			"Hello, this is third fortune"
	};
	
	// Create a random number generator
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		
		return theFortune;
	}

}
