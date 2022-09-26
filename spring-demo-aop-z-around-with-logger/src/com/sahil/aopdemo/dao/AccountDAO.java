package com.sahil.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

import com.sahil.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	// Add a new method- findAccounts()
	
	public List<Account> findAccounts(boolean flag){
		
		// Simulating an exception
		if(flag) {
			throw new RuntimeException("This is a custom simulated exception.");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		// Create sample data for accounts
		Account a1 = new Account("Karim","st");
		Account a2 = new Account("Vini","lw");
		Account a3 = new Account("Eder","cb");
		Account a4 = new Account("Tibo","gk");
		
		// Add them to account list
		myAccounts.add(a1);
		myAccounts.add(a2);
		myAccounts.add(a3);
		myAccounts.add(a4);
		
		return myAccounts;
	}
	
	

	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + " Adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " AccountDAO - Do work");
		return false;
	}
	
	// Getter and Setters

	public String getName() {
		System.out.println("AccountDAO- getName getter method");
		return name;
	}

	public void setName(String name) {
		System.out.println("AccountDAO- setName setter method");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("AccountDAO- getServiceCode getter method");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("AccountDAO- setServiceCode setter method");
		this.serviceCode = serviceCode;
	}
	
	
	
}
