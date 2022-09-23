package com.sahil.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sahil.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect { 
	
	@AfterThrowing(pointcut = "execution(* com.sahil.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "myExc")
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint, Throwable myExc) {
		
		// Print out the method name
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n -------> Executing @AfterThrowing on : " + method);
		
		// log the exception
		
		System.out.println("The exception is: " + myExc);
		
	}
	

	// Add @AfterReturning advice
	
	@AfterReturning(
			pointcut = "execution(* com.sahil.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		/* returning value and method parameter must be same name */  
		
		// Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n -------> Executing @AfterReturning on : " + method);
		
		// Print out the results of the method call
		System.out.println("\n -------> Result is: " + result);
		
		// If we post process the data then the calling program will get the modified data
		
		// Let's post-process the data
		
		convertAccountNameToUpperCase(result);
		
		System.out.println("\n -------> Result is: " + result);
		
	}
	
	
	private void convertAccountNameToUpperCase(List<Account> result) {

		for(Account temp : result) {
			
			String upperName = temp.getName().toUpperCase();
			temp.setName(upperName);
		}
		
	}


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
