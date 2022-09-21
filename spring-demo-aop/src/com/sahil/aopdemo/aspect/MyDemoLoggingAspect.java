package com.sahil.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// @Before("execution(public void addAccount())")
	// @Before("execution(public void com.sahil.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(* add*(com.sahil.aopdemo.Account,..))")
	// @Before("execution(* add*(..))")
	// @Before("execution(* com.sahil.aopdemo.dao.*.*(..))")
	
	@Before("execution(* com.sahil.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("------> Executing @Before advice on addAccount()");
	}
	
}
