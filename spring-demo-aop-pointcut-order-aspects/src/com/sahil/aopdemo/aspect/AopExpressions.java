package com.sahil.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.sahil.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	// Create point cut for getter
	@Pointcut("execution(* com.sahil.aopdemo.dao.*.get*(..))")
	public void getter() {}

	// Create point cut for setter
	@Pointcut("execution(* com.sahil.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// Create point cut: include package ... exclude getter/setter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackageNoGetterSetter() {}
	
}
