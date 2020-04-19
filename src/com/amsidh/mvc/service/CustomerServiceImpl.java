package com.amsidh.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amsidh.mvc.dao.CustomerDao;
import com.amsidh.mvc.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);

	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

}
