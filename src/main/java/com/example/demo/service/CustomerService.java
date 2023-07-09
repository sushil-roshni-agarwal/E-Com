package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Customer;

public interface CustomerService {

	Customer regsiterCustomer(Customer cust);

	  boolean loginCustomer(Customer cust);
	
	  List<Customer> getCustomers();
	
	  Customer updateCustomerByUserName(String userName, @Valid Customer cust) throws Exception;
	
	  Customer getCustomerById(int id);
	
	  Customer getCustomerByUserName(String userName);
}
