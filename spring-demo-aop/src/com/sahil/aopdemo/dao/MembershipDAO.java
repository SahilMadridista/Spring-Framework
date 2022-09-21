package com.sahil.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMembership() {
		System.out.println(getClass() + "Adding MembershipDAO Method");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + " Go to sleep membership DAO");
	}
	
}
