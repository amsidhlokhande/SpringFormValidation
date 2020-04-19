package com.amsidh.mvc.service;

import java.util.List;

import com.amsidh.mvc.model.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer customer);

	public List<Customer> getAllCustomer();

}
