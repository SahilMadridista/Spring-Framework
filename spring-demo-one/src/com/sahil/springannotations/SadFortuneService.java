package com.sahil.springannotations;

public class SadFortuneService implements FortuneService2 {

	@Override
	public String getFortune() {
		
		return "Today is a !sad day.";
		
	}

}
