package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class getStudentAddClassesDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//get session
		Session session = factory.openSession();
		
		try {
			//start transaction
			System.out.println("Starting transaction");
			session.beginTransaction();
			
			//get Student
			Student josh = session.get(Student.class, 1);
			Student court = session.get(Student.class, 2);
			
			//create more classes
			Course economics = new Course("Cowboy Economics");
			Course cuddlin = new Course("Cuddlin' Kitties");
			Course snackin = new Course("Snackin and Nappin");
			Course haters101 = new Course("Handling the Haters");
			
			//add student to classes
			josh.add(economics);
			haters101.add(josh);
			
			court.add(cuddlin);
			snackin.add(court);
			
			Course[] courses = {economics, cuddlin, snackin, haters101};
			
			for (Course c: courses) {
				session.save(c);
			}
			
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
