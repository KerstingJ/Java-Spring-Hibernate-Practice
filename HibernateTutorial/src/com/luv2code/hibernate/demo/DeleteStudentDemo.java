package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// begin Transaction
			System.out.println("Starting transaction");
			session.beginTransaction();
			
			/*
				// Get student
				System.out.println("Getting Student");
				Student student = session.get(Student.class, 3);
				System.out.println("Got student: " + student);
				
				// delete student
				System.out.println("Deleting student");
				session.delete(student);
				
				// commit changes
				session.getTransaction().commit();
			*/
			
			session.createQuery("delete from Student where id=1").executeUpdate();
			
			session.getTransaction().commit();
				
		} finally {
			
			System.out.println("closing session factory");
			// close the factory
			
			session.close();
			
			factory.close();
			
		}

	}

}
