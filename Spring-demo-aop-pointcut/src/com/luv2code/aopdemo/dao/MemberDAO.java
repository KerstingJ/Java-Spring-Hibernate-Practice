package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class MemberDAO {
	
	public void addAccount(Account a, String s) {
		System.out.println(getClass() + ": adding account");
	}
	
	public void addMember() {
		System.out.println(getClass() + ": adding member");
	}

}
