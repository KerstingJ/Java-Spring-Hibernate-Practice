package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//get session factory
		//this could be a bean?
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//get session
		Session session = factory.openSession();
		
		try {
			//create student
			System.out.println("Creating new student");
			Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");
			
			//start transaction
			System.out.println("Starting transaction");
			session.beginTransaction();
			
			//save student
			System.out.println("adding student");
			session.save(tempStudent);
			
			//commit transaction
			System.out.println("commiting changes");
			session.getTransaction().commit();
			
			System.out.println("Done! everything went as planned");
				
		} finally {
			
			System.out.println("closing session factory");
			// close the factory
			
			session.close();
			
			factory.close();
			
		}

	}

}
