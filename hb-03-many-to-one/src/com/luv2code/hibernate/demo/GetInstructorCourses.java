package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCourses {

	public static void main(String[] args) {
		
		//get session factory
		//this could be a bean?
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//get session
		Session session = factory.openSession();
		
		try {
			//start transaction
			System.out.println("Starting transaction");
			session.beginTransaction();
			
			//create objects
			Instructor gotti = session.get(Instructor.class, 3);
			System.out.println(gotti);
			
			List<Course> courses = gotti.getCourses();
			System.out.println(courses);
			
			System.out.println("\n\n");
			
			Course kitties = session.get(Course.class, 12);
			System.out.println(kitties);
			
			Instructor kittyTeach = kitties.getInstructor();
			System.out.println(kittyTeach);
			
	
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
