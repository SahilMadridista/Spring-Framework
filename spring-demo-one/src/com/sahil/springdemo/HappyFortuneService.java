package com.sahil.springdemo;

public class HappyFortuneService implements FortuneService {

	// Bean id = "myFortune"
	
	@Override
	public String getFortune() {
		return "You'll have a great day at baseball.";
	}

}
