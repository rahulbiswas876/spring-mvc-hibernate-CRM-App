package com.rahul.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.entity.Customer;


@Repository
public class CustomerDAOImp implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> listCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Customer");
		List<Customer> result = query.list();
		return result;
	}

	@Override
	public void saveCustomer(Customer customer) {
		//get session
		Session session = sessionFactory.getCurrentSession();
		
		//save the entity
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		//get session
		Session session = sessionFactory.getCurrentSession();
		
		
		//get the customer
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		
		//delete customer by id
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
	}

}
