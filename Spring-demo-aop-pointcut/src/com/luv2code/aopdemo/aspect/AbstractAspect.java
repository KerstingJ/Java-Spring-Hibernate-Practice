package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AbstractAspect {
	
	//PointCut Declerations
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
	public void anyInDAOPackage() {};
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.get*(..))")
	public void getMethods() {};
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.set*(..))")
	public void setMethods() {};
	
	@Pointcut("anyInDAOPackage() && !(getMethods() || setMethods())")
	public void inDaoPackageNotGetterSetter() {}

}