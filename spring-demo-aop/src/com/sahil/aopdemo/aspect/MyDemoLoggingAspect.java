package com.sahil.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	
//	@Before("execution(public void addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("------> Executing @Before advice on addAccount()");
//	}
	
	
	/* 
	 
	  We have 2 classes in which addAccount method is present that are AccountDAO and MembershipDAO. So If we define @Before("execution(public void addAccount())"), this will run 
	 for the method in both the classes. If we want to specify a particular class, we have to define it in the @Before annotation. How to define this is given below.
	 
	 	
	 */
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("------> Executing @Before advice on addAccount()");
	}
	
}
