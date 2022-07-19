package com.sahil.springannotations;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService2 {

	@Override
	public String getFortune() {
		return "Random service.";
	}

}
