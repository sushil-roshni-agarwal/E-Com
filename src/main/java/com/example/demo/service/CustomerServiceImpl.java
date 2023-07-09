package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.InvalidUserNameException;
import com.example.demo.model.Customer;
import com.example.demo.model.repositry.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	  CustomerRepo Cr;
	//   OrderRepo Or;

	  @Override
	  public Customer regsiterCustomer(Customer cust) {
	    return Cr.save(cust);
	  }

	  @Override
	  public boolean loginCustomer(Customer cust) {
	    Customer databaseObject = Cr.findBycustUserName(cust.getCustUserName());
	    if (databaseObject == null){ return false; }
	    if (databaseObject.getCustUserName().equals(cust.getCustUserName())
	      && databaseObject.getCustPassword().equals(cust.getCustPassword())){
	      return true;
	    }
	    return false;
	  }

	  @Override
	  public List<Customer> getCustomers() {
	    return Cr.findAll();

	  }
	
	  @Override
	  public Customer updateCustomerByUserName(String userName, Customer cust) throws Exception {
	    Customer ans = null;
	    Customer dataFromDb = Cr.findBycustUserName(userName);
	    if (dataFromDb == null) throw new InvalidUserNameException("username doesnt exist");
	    dataFromDb.setCustUserName(cust.getCustUserName());
	    System.out.println("updated the user name");
	    return Cr.save(dataFromDb);
	  }
	
	  @Override
	  public Customer getCustomerById(int id) {
	    return Cr.findById(id).get();
	  }

	  @Override
	  public Customer getCustomerByUserName(String userName) {
	    return Cr.findBycustUserName(userName);
	  }

}
