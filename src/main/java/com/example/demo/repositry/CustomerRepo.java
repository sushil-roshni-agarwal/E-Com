package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>{
	public Customer findBycustUserName(String custUserName);
	public Customer findBycustId(int customerId);
	
}
