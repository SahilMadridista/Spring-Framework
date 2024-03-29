package com.sahil.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect { 

	
	@Before("com.sahil.aopdemo.aspect.AopExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("------> Executing @Before advice on addAccount()");
	}
	
	
}
