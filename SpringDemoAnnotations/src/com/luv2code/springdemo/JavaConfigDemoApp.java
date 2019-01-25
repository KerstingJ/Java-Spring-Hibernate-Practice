package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		//load config
		/*
		 * using AnnotationConfig uses a class instead of xml
		 */
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get yer beans
		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		
		//make yer coffee
		System.out.println(myCoach.getDailyFortune());
		
		//close shop
		context.close();

	}

}
