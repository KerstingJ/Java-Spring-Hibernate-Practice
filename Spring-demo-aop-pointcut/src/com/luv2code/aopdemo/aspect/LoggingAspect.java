package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect extends AbstractAspect{
	
	//Aspect Advice
	@Before("inDaoPackageNotGetterSetter()")
	public void forDaoPackageNotGetterSetter() {
		System.out.println("@Before any method in dao not getter or setter");
	}
	
	@After("inDaoPackageNotGetterSetter()")
	public void apiAnalytics() {
		System.out.println("@After api analytics");
	}

}