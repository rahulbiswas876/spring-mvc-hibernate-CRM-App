package com.rahul.dao;

import java.util.List;

import com.rahul.entity.Customer;

public interface CustomerDAO {

	public List<Customer> listCustomers() ;

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int customerId);
}
