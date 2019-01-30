package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//PointCut Declerations
	@Pointcut("execution(* *(..))")
	public void anyMethod() {};
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
	public void anyInDAOPackage() {};
	
	@Pointcut("execution(* *add*(..))")
	public void anyAddMethods() {};
	
	//Aspect Advice
	@Before("anyMethod()")
	public void beforeAnyMethods() {
		System.out.println("=====>>> @Before any Method");
	}
	
	@Before("anyAddMethods()")
	public void beforeAddMethods() {
		System.out.println("=====>>> @Before any Add Methods");
	}
	
	@Before("anyInDAOPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>> @Before advice on any method in DAO package");
	}
	
	@After("execution(public * com.luv2code.aopdemo.dao.MemberDAO.add*(..))")
	public void afterMemberDAOAddAdvice() {
		System.out.println("=====>>> @After advice on any method in MemberDAO.class starting with add");
	}
	
	@After("anyMethod()")
	public void afterVoidMethod() {
		System.out.println("=====>>> @After any methods that return void");
	}

}