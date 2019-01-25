package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 3;
			InstructorDetail insDet = session.get(InstructorDetail.class, theId);
			System.out.println(insDet);
			
			
			//remove reference to Detail on Instructor
			Instructor tempIns = insDet.getInstructor();
			tempIns.setInstructorDetail(null);
			
			
			//delete Instructor detail
			System.out.println("Deleting insDet 2");
			session.delete(insDet);
			
			session.getTransaction().commit();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		
		} finally {
			
			session.close();
			factory.close();
			
		}

	}

}
