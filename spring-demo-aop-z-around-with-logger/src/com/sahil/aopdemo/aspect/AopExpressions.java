package com.sahil.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.sahil.aopdemo.dao.*.add*(..))")
	public void forDAOPackage() {}
	
	// The above point cur expression means-
	// First * - Any return type
	// com.sahil.aopdemo.dao - Package name
	// Second * - Any class name
	// Third * - Any method name
	// (..) - 0 or more arguments of any type
	
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
