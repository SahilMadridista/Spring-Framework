 package com.sahil.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
	implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode cc) {
		coursePrefix = cc.value();
	}
	
	
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext cvc) {
		
		boolean result;
		
		if(theCode != null){
			result = theCode.startsWith(coursePrefix);
		}else {
			result = true;
		}
		
		return result;
	}
	
	
	

}
