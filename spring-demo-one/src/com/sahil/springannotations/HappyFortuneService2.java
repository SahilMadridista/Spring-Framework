package com.sahil.springannotations;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService2 implements FortuneService2 {

	@Override
	public String getFortune() {
		return "This is your fortune- Good Luck";
	}

}
