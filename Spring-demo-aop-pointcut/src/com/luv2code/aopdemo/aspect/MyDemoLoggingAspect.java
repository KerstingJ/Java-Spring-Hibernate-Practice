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
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
	public void anyInDAOPackage() {};
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.get*(..))")
	public void getMethods() {};
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.set*(..))")
	public void setMethods() {};
	
	@Pointcut("anyInDAOPackage() && !(getMethods() || setMethods())")
	public void inDaoPackageNotGetterSetter() {}
	
	//Aspect Advice
	@Before("inDaoPackageNotGetterSetter()")
	public void forDaoPackageNotGetterSetter() {
		System.out.println("@Before any method in dao not getter or setter");
	}
	
	@After("anyInDAOPackage()")
	public void forAnyDaoPackage() {
		System.out.println("@After any method in dao\n\n");
	}


}