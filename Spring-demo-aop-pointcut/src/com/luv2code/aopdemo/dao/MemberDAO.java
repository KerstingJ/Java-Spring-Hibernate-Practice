package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class MemberDAO {
	
	private int id;
	private String name;
	private String email;
	private int code;
	
	public void doSomething() {
		System.out.println(getClass() + ".doSomething");
		System.out.println("=====>>> we're doing something");
	}
	
	public void doSomethingWithGetSet() {
		System.out.println(getClass() +".doSomethingWithGetSet");
		System.out.println("=====>>> we're doing something with get set");
		this.setEmail("changed@Email.com");
		this.setCode(34);
	}
	
	public int getId() {
		System.out.println(getClass() + ".getId");
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		System.out.println(getClass() + ".setId");
	}
	
	public String getName() {
		System.out.println(getClass() + ".getName");
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println(getClass() + ".setName");
	}
	
	public String getEmail() {
		System.out.println(getClass() + ".getEmail");
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
		System.out.println(getClass() + ".setEmail");
	}
	
	public int getCode() {
		System.out.println(getClass() + ".getCode");
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
		System.out.println(getClass() + ".setId");
	}

}
