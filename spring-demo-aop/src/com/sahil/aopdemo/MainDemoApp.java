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
		theAccountDAO.addAccount();
		System.out.println("\n\n");
		theMembershipDAO.addAccount();
		
		// Close the context
		context.close();
		
	}
	
}
