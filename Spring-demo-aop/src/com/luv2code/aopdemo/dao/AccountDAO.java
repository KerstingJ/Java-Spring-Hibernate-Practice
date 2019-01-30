package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": Doing DB Work Adding Account");
	}
	
	public void addAccountant() {
		System.out.println(getClass() + ": adding accountant to account");
	}
	
	public void addingStuff() {
		System.out.println(getClass() + ": adding stuffff");
	}
}
