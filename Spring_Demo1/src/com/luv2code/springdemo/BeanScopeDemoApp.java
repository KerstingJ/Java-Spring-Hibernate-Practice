package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load config
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("BeanScope-ApplicationContext.xml");
		
		// get beans from container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		
		// are theCoach and alphaCoach pointing to the same space in memory
		/// are they the same object
		boolean result = theCoach == alphaCoach;
		
		System.out.println(result);
		System.out.println("/nThe memory location for 'theCoach' " + theCoach);
		System.out.println("/nThe memory location for 'alphaCoach' " + alphaCoach);
		
		
		// close context
		context.close();

	}

}
