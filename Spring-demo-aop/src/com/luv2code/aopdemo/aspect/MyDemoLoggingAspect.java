package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Before("execution( * *())")
	public void beforeAnyMethods() {
		System.out.println("=====>>> @Before every method that takes no params");
	}

	//start with @Before Advice	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice( ) {
		
		System.out.println("=====>>> @Before advice on addAccount() in any Class");

	}
	
	@Before("execution(* *(com.luv2code.aopdemo.Account))")
	public void beforeMethodTakesOnlyAnAccountAsParam( ) {
		
		System.out.println("=====>>> @Before methods that take Only an Account.class object as a Parameter");

	}
	
	@Before("execution(* *(com.luv2code.aopdemo.Account, *))")
	public void beforeMethodTakesAccountAsParamAndOtherParams( ) {
		
		System.out.println("=====>>> @Before methods that take an Account.class object as one of its params");

	}
	
	@After("execution(public * com.luv2code.aopdemo.dao.AccountDAO.add*())")
	public void afterAccountDAOAddAdvice() {
		
		System.out.println("=====>>> @After advice on any method in AccountDAO.class+ starting with add");

	}
	
	@After("execution(public * com.luv2code.aopdemo.dao.MemberDAO.add*())")
	public void afterMemberDAOAddAdvice() {
		
		System.out.println("=====>>> @After advice on any method in MemberDAO.class+ starting with add");

	}
	
	@After("execution(void *())")
	public void afterVoidMethod() {
		
		System.out.println("=====>>> @After any methods that return void");
	}

}