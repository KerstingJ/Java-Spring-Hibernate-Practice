package com.hb.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.practice.entity.Employee;

public class PracticeAppOne {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Employee employee;
		
		try {
			session.beginTransaction();
			
			//add employee to table
			System.out.println("\n\nAddding employee: ");
			employee = new Employee("John", "Gotti", "Self Employeed");
			session.save(employee);
			session.getTransaction().commit();
			
			
			session.beginTransaction();
			System.out.println("\n\nGetting all employees: ");
			@SuppressWarnings(value = { "unchecked" })
			List<Employee> employees = 
					session.createQuery("from Employee").getResultList();
			System.out.println("DB has " + employees.size() + " employees");
			for (Employee emp: employees) {
				System.out.println(emp);
			}
			
			//update employee in table
			System.out.println("\n\nUpdating Employees");
			employee = session.get(Employee.class, 1);
			employee.setEmployer("unemployed");
			
			session.getTransaction().commit();
			
			session.beginTransaction();
			employee = session.get(Employee.class, 1);
			if (employee.getEmployer().equals("unemployeed")) {
				System.out.println("employee updated correctly");
			}
			System.out.println(employee);
			
			//delete a employee from table
			System.out.println("\n\nDeleting Employee");
			session.createQuery("delete from Employee where id=1").executeUpdate();
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
