package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// related advices for logging
	
	//start with @Before Advice
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice( ) {
		
		System.out.println("\n=====>>> @Before advice on addAccount()");
	}

}
