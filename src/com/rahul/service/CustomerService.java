package com.rahul.service;

import java.util.List;

import com.rahul.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
