package com.sahil.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Have a great day- HappyFortuneService";
	}

}
