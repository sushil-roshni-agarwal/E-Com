package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Orderr;
import com.example.demo.model.Product;
import com.example.demo.model.repositry.CustomerRepo;
import com.example.demo.model.repositry.OrderRepository;
import com.example.demo.model.repositry.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	CustomerService Cs;
	
	@Autowired
	OrderService Os;
	@Autowired
	CustomerRepo customerRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Orderr createOrder(Orderr order,int cid,int pid) {
		Customer customer=customerRepository.findById(cid).orElse(null);	
		order.setCustomer(customer);
		System.out.println("fgh   "+pid);
		Product product= productRepository.findById(pid).orElse(null);
		order.setProduct(product);
		return orderRepository.save(order);
	}
	public List<Orderr> showOrdersList(int id){
		Customer customer=customerRepository.findById(id).orElse(null);
		return orderRepository.getOrdList(customer);
	}
}
