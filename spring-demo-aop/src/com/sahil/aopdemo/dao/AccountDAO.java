package com.sahil.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.sahil.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + " Adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " AccountDAO - Do work");
		return false;
	}
	
}
