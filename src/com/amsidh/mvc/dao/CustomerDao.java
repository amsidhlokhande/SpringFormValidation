package com.amsidh.mvc.dao;

import java.util.List;

import com.amsidh.mvc.model.Customer;

public interface CustomerDao {
	public void addCustomer(Customer customer);

	public List<Customer> getAllCustomer();
}
