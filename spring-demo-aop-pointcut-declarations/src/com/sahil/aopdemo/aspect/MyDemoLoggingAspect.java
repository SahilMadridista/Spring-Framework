package com.sahil.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
	
	@Pointcut("execution(* com.sahil.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	// Create point cut for getter
	@Pointcut("execution(* com.sahil.aopdemo.dao.*.get*(..))")
	private void getter() {}

	// Create point cut for setter
	@Pointcut("execution(* com.sahil.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// Create point cut: include package ... exclude getter/setter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void forDAOPackageNoGetterSetter() {}
	
	
	@Before("forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("------> Executing @Before advice on addAccount()");
	}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void performAPIAnalytics() {
		System.out.println("------> Performing API analytics");
	}
	
}
