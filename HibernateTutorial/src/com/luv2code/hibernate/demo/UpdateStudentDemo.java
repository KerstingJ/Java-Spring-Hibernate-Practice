package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			
		int studentID = 3;
		
		System.out.println("getting student with id: " + studentID);
		Student myStudent = session.get(Student.class, studentID);
		
		System.out.println("got student: " + myStudent);
		
		System.out.println("Changing student name to Scooby");
		myStudent.setFirstName("Scooby");
		
		System.out.println("Printing Student:\n" + myStudent);
		
		session.getTransaction().commit();
		
		//mass update emails
		
		session.beginTransaction();
		
		List<Student> students = session.createQuery("from Student").getResultList();
		
		for (Student s: students) {
			String newEmail = s.getFirstName().charAt(0) + "." + s.getLastName() + "@gmail.com";
			System.out.println(newEmail);
			
			s.setEmail(newEmail);
		}
		
		session.getTransaction().commit();
		} finally {
			factory.close();
		}


	}

	private static void showStudents(List<Student> students) {
		for (Student s: students) {
			System.out.println(s);
		}
	}

}
