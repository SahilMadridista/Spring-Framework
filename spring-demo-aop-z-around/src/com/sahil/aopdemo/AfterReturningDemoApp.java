package com.sahil.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.sahil.aopdemo.dao.AccountDAO;
import com.sahil.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		
		// Read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		// Call the findAccounts() business method    
		List<Account> theAccounts = theAccountDAO.findAccounts(true);
		
		// Display the accounts
		System.out.println("-----AfterReturningDemoApp-----");
		System.out.println("Account list: " + theAccounts);
		System.out.println("\n");
		
		// Close the context
		context.close();
		
	}
	
}
