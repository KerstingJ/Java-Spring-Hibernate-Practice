package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class CloudAspect extends AbstractAspect{
	
	@After("anyInDAOPackage()")
	public void forAnyDaoPackage() {
		System.out.println("@After any method in dao\n\n");
		
	}
	
	
}
