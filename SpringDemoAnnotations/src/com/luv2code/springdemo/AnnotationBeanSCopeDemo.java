package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanSCopeDemo {

	public static void main(String[] args) {
		// load config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// get our beans
		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		
		// do the meat
		// are they the same?
		System.out.println(myCoach == alphaCoach);
		
		//
		System.out.println("/n myCoach is at memory location " + myCoach.toString());
		System.out.println("/n alphaCoach is at memory location " + alphaCoach.toString());
		
		// close the door
		context.close();

	}

}
