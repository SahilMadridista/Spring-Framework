package com.sahil.springannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.sahil.springannotations")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// Define a bean for sad fortune service
	
	// the method name willbe the actual bean id
	
	@Bean
	public FortuneService2 sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	
	// define bean for swim coach and inject dependencies
	
	@Bean
	public CoachInterface swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	 
	
}
