package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddStudentAndCourseDemo {

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
			
			//create a course
			Course tempCourse = new Course("Columbian Chemistry");
			
			//create Student
			Student tempStudent = new Student("Josh", "Kersting", "Josh.Kersting@Gmail.com");
			Student court = new Student("Court", "Hunter", "Josh.Kersting@Gmail.com");
			
			//add student to course
			tempCourse.add(court);
			
			//add course to student
			tempStudent.add(tempCourse);
			
			session.save(tempCourse);
			session.save(tempStudent);
			session.save(court);
			
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
