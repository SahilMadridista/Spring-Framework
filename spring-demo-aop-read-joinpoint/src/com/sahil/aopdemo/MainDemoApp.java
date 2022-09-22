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
		
		Account myAccount = new Account("Sergio","4");
		
		theAccountDAO.addAccount(myAccount,true);
		System.out.println("\n");
		theAccountDAO.doWork();
		
		System.out.println("\n");
		theAccountDAO.setName("Sahil");
		
		System.out.println("\n");
		theAccountDAO.setServiceCode("1234");
		
		System.out.println("\n");
		String name = theAccountDAO.getName();
		
		System.out.println("\n");
		String serviceCode = theAccountDAO.getServiceCode();
		
		System.out.println("\n");
		theMembershipDAO.addMembership();
		
		System.out.println("\n");
		theMembershipDAO.goToSleep();
		
		// Close the context
		context.close();
		
	}
	
}
