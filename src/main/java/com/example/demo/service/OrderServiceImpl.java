package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Orderr;
import com.example.demo.model.Product;
import com.example.demo.repositry.CustomerRepo;
import com.example.demo.repositry.OrderRepository;
import com.example.demo.repositry.ProductRepository;

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
	public Orderr createOrder(int customerId, List<Integer> productIds) {
        Customer customer = customerRepository.findBycustId(customerId);
        System.out.println(customer.getCustId());
        
        List<Product> products=new ArrayList<Product>();
        for(Integer p : productIds) {
        	if(!productRepository.findById(p).isEmpty()) {
        		products.add(productRepository.findById(p).get());
        	}
        }
        
        for(Product p:products) {
        	System.out.println(p.getProductPrice());
        }
        
        double totalAmount=21;
        if(!products.isEmpty()) {
             totalAmount = products.stream().mapToDouble(Product::getProductPrice).sum();
        }

        Orderr order = new Orderr();
        order.setCustomer(customer);
        order.setProducts(products);
        order.setTotalAmount(totalAmount);

        return orderRepository.save(order);
    }

}
