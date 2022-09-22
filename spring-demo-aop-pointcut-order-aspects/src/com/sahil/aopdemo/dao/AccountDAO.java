package com.sahil.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.sahil.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

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
