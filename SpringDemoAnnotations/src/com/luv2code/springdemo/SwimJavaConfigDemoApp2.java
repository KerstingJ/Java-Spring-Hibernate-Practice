package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp2 {

	public static void main(String[] args) {
		
		//load config
		/*
		 * using AnnotationConfig uses a class instead of xml
		 */
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get yer beans
		SwimCoach myCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//make yer coffee
		System.out.println(myCoach.getDailyFortune());
		System.out.println("Coach's email is " + myCoach.getEmail());
		System.out.println("Team is " + myCoach.getTeam());
		//close shop
		context.close();

	}

}
