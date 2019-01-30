package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
	
	//Aspect Advice
	@Before("com.luv2code.aopdemo.aspect.AbstractAspect.inDaoPackageNotGetterSetter()")
	public void forDaoPackageNotGetterSetter() {
		System.out.println("@Before any method in dao not getter or setter");
	}
	
	@After("com.luv2code.aopdemo.aspect.AbstractAspect.inDaoPackageNotGetterSetter()")
	public void apiAnalytics() {
		System.out.println("@After api analytics");
	}

}