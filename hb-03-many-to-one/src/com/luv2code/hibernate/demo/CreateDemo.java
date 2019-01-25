package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//get session factory
		//this could be a bean?
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//get session
		Session session = factory.openSession();
		
		try {
			//start transaction
			System.out.println("Starting transaction");
			session.beginTransaction();
			
			//create objects
			
			Instructor ins = new Instructor("Joshua", "Kersting", "Kersting.Josh@Gmail.com");
			InstructorDetail det = new InstructorDetail("No Youtube", "Photography, Programming");

			Instructor ins2 = new Instructor("Courtney", "Hunter", "SweetestLilAngel@Gmail.com");
			InstructorDetail det2 = new InstructorDetail("ToCyootForYoutube", "Being amazing mother to our son");
			
			//associate objects
			ins.setInstructorDetail(det);
			ins2.setInstructorDetail(det2);
			
			//save objects
			/*
			 * will save both objects thanks to the cascade type
			 */
			session.save(ins);
			session.save(ins2);
			
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
