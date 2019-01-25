package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSetterApp {

	public static void main(String[] args) {
		
		// load spring config
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		//retrieve bean
			Coach theCoach = context.getBean("mySetterCoach", Coach.class);
		
		//call bean methods
			System.out.println(theCoach.getDailyFortune());
			System.out.println(theCoach.getDailyWorkout());
			
			if (theCoach.getEmailAndTeam() != null) {
				System.out.println(theCoach.getEmailAndTeam());
			} else {
				System.out.println("No email or team on file");
			}
		
		//close context
			context.close();
	}

}
