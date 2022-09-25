package com.sahil.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.sahil.aopdemo.dao.AccountDAO;
import com.sahil.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		
		// Read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> theAccounts = null;
		
		try {
			// Add a boolean flag to simulate an exception
			boolean flag = true;
			theAccounts = theAccountDAO.findAccounts(flag);
			
		}catch(Exception e) {
			System.out.println("\nExcepion caught... " + e);	
		}
		
		// Call the findAccounts() business method    
		
		
		// Display the accounts
		System.out.println("-----AfterThrowingDemoApp-----");
		System.out.println("Account list: " + theAccounts);
		System.out.println("\n");
		
		// Close the context
		context.close();
		
	}
	
}
