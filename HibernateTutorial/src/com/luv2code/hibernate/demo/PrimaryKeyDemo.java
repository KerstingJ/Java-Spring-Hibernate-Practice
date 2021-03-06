package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
				System.out.println("Creating students");
				Student tempStudent = new Student("John", "Gotti", "John@luv2code.com");
				Student tempStudent1 = new Student("Kevin", "Gates", "Kevin@luv2code.com");
				Student tempStudent2 = new Student("Barry", "O'baby", "Barry@luv2code.com");
				Student tempStudent3 = new Student("Jerry", "Rigged", "J@luv2code.com");
				
				Student[] students = {tempStudent, tempStudent1, tempStudent2, tempStudent3};
				
				//start transaction
				System.out.println("Starting transaction:");
				session.beginTransaction();
				
				for (Student student: students) {
					//save student
					System.out.println("adding: " + student);
					session.save(student);
				}
				
				//commit transaction
				System.out.println("commiting changes");
				session.getTransaction().commit();
				
				System.out.println("Done! everything went as planned\n");
					
			} finally {
				
				System.out.println("closing session factory");
				// close the factory
				
				session.close();
				
				factory.close();
				
			}

		}

	}
