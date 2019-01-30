package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": adding account");
	}
	
	public void addMember() {
		System.out.println(getClass() + ": adding member");
	}

}
