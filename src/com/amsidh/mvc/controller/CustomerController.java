package com.amsidh.mvc.controller;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amsidh.mvc.model.Customer;
import com.amsidh.mvc.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/index")
	public ModelAndView homePage(@ModelAttribute("customer") Customer customer) {
		customer = new Customer();

		return new ModelAndView("home", "customerList",
				customerService.getAllCustomer());
	}

	@RequestMapping("addCustomer")
	public ModelAndView addCustomer(
			@ModelAttribute("customer") Customer customer, BindingResult result) {
		// do validation here
		System.out.println(customer.getCustomerName());
		customerService.addCustomer(customer);
		return new ModelAndView("success", "cutomer", customer);
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
