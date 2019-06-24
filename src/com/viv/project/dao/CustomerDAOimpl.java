package com.viv.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viv.project.entity.Customer;

@Repository
public class CustomerDAOimpl implements CustomerDAO {

	@Autowired
	public SessionFactory sessionFactory; 
	//Inject session factory using 
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//put query
		Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
		
		//get list
		List<Customer> customers = theQuery.getResultList();
		
		//return list
		return customers;
	}
	

}
