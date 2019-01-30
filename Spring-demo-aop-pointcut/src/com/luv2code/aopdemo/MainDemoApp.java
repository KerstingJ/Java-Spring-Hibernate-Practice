package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MemberDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//Read Configuration File
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
		
		Account a = new Account();
		
		// call the business method
		memberDAO.setId(1);
		memberDAO.setName("josh");
		memberDAO.setEmail("josh@Email.com");
		memberDAO.setCode(12345);
		memberDAO.doSomething();
		memberDAO.doSomethingWithGetSet();
		System.out.println(memberDAO.getEmail() + "\n\n");
		System.out.println(memberDAO.getCode() + "\n\n");
		
		//close context
		context.close();

	}

}
