package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			
			List<Student> students = session.createQuery("from Student s WHERE s.lastName='Gotti' OR s.firstName='kevin'").getResultList();
			
			showStudents(students);
			
			students = session.createQuery("from Student s Where s.email LIKE '%gmail.com'").getResultList();
			
			System.out.println("\nWith email Gmail");
			showStudents(students);
			
		} finally {
			session.close();
			factory.close();
		}

	}

	private static void showStudents(List<Student> students) {
		for (Student s: students) {
			System.out.println(s);
		}
	}

}
