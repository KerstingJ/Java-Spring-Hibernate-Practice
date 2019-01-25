package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			//get instructors
			Instructor courtney = session.get(Instructor.class, 2);
			Instructor gotti = session.get(Instructor.class, 3);
			Instructor anitta = session.get(Instructor.class, 4);
			
			
			//make some courses
			Course c1 = new Course("Cowboy Economics");
			Course c2 = new Course("Columbian Chemsitry");
			
			Course c3 = new Course("Cuddlin' Kitties");
			Course c4 = new Course("Snackin and Nappin");
			
			Course c5 = new Course("Salary Negotiating");
			Course c6 = new Course("Handling the Haters");
			
			//add courses to instructor
			courtney.add(c3);
			courtney.add(c4);
			
			gotti.add(c1);
			gotti.add(c2);
			
			anitta.add(c5);
			anitta.add(c6);
			
			//save courses
			
			Course[] courses = {c1, c2, c3, c4, c5, c6};
			
			for (Course c: courses) {
				session.save(c);
			}
			
			//commit transaction
			System.out.println("commiting changes");
			session.getTransaction().commit();
			
			System.out.println("Done! everything went as planned");
				
		} finally {
			
			System.out.println("closing session and factory");
			// close the factory
			
			session.close();
			
			factory.close();
			
		}

	}

}
