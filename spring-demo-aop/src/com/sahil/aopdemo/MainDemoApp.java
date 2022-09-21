package com.sahil.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.sahil.aopdemo.dao.AccountDAO;
import com.sahil.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		
		// Read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		// Call the business method
		
		Account myAccount = new Account();
		
		theAccountDAO.addAccount(myAccount,true);
		System.out.println("\n");
		theAccountDAO.doWork();
		System.out.println("\n");
		theMembershipDAO.addMembership();
		System.out.println("\n");
		theMembershipDAO.goToSleep();
		
		// Close the context
		context.close();
		
	}
	
}
