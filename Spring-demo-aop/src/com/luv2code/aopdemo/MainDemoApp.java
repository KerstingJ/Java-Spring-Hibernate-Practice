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
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
		
		// call the business method
		accountDAO.addAccount();
		accountDAO.addAccountant();
		accountDAO.addingStuff();
		
		memberDAO.addAccount();
		memberDAO.addMember();
		
		//close context
		context.close();

	}

}
