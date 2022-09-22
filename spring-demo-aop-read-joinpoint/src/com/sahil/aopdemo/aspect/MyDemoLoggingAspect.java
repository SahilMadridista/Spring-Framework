package com.sahil.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sahil.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect { 

	
	@Before("com.sahil.aopdemo.aspect.AopExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("------> Executing @Before advice on addAccount()");
		
		System.out.println("----Method Signature----");
		
		// Display the method signature
		MethodSignature methSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methSig);
		
		// Display method arguments

		// Get arguments
		Object[] args = theJoinPoint.getArgs();
		
		// Loop through arguments
		for(Object temp : args) {
			System.out.println("Object: " + temp);
			
			if(temp instanceof Account) {
				// Downcast and print Account specific stuff
				Account theAccount = (Account) temp;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account name: " + theAccount.getLevel());
			}
			
		}
		
		
	}
	
	
}
