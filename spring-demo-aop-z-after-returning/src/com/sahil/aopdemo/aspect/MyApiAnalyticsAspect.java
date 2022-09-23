package com.sahil.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.sahil.aopdemo.aspect.AopExpressions.forDAOPackageNoGetterSetter()")
	public void performAPIAnalyticsAdvice() {
		System.out.println("------> Performing API analytics");
	}
	
}
