package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		
		//get Current Session
		Session session = sessionFactory.getCurrentSession();
		
		//Hibernate Query
		Query<Customer> theQuery = 
				session.createQuery("from Customer order by lastName", Customer.class);
		
		//get the result list
		List<Customer> customerList = theQuery.getResultList();
		
		
		return customerList;
	}
	
	@Override
	public Customer getCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void saveCustomer(Customer c) {
		
		//get current session
		Session session = sessionFactory.getCurrentSession();
		
		//save Customer to Database
		session.saveOrUpdate(c);
		
	}
	
	@Override
	public void deleteCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		//set HQL query
		Query<?> theQuery = session.createQuery("delete from Customer where id=:customerId");
		
		//set the paramater value for query
		theQuery.setParameter("customerId", theId);
		
		//execute the query
		theQuery.executeUpdate();
		
	}

}
