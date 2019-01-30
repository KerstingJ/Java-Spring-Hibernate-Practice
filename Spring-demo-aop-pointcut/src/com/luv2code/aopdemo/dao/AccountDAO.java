package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ": Doing DB Work Adding Account");
	}
	
	public void addAccountant() {
		System.out.println(getClass() + ": adding accountant to account");
	}
	
	public boolean addingStuff() {
		System.out.println(getClass() + ": adding stuffff");
		
		return true;
	}
}
