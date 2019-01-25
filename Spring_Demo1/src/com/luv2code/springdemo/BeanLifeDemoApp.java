package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeDemoApp {

	public static void main(String[] args) {
		
		// load xml config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("BeanLife-ApplicationContext.xml");
		
		// make my beans
		
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		// brew my coffee
		
		
		//close my beans
		context.close();

	}

}
