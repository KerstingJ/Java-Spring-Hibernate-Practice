package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class UniDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 2;
			InstructorDetail insDet = session.get(InstructorDetail.class, theId);
			System.out.println(insDet);
			Instructor ins = insDet.getInstructor();
			System.out.println(ins);
			
			session.getTransaction().commit();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		
		} finally {
			
			session.close();
			factory.close();
			
		}

	}

}
