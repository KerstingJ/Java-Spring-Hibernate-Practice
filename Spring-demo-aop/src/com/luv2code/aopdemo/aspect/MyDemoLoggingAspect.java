package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//start with @Before Advice	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice( ) {
		
		System.out.println("\n=====>>> @Before advice on addAccount()");
		System.out.println("=====>>>\t" + getClass() + "\n");
	}
	
	@After("execution(public void com.luv2code.aopdemo.dao.MemberDAO.add*())")
	public void afterAddAdvice() {
		
		System.out.println("\n=====>>> @After advice on any method starting with add");
		System.out.println("=====>>>\t" + getClass() + "\n");
	}

}