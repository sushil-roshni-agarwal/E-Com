package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.OrderItem;
import com.example.demo.model.Orderr;
import com.example.demo.model.Product;
import com.example.demo.repositry.CustomerRepo;
import com.example.demo.repositry.OrderItemRepositry;
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
	
	@Autowired
	OrderItemRepositry orderItemRepositry;
	
	@Override
	@Transactional
	public String createOrder(Orderr ord) {

		String userName=ord.getCustomer().getCustUserName();
		if(userName!=null) {
			Orderr order=new Orderr();
			Customer c=customerRepository.findBycustUserName(ord.getCustomer().getCustUserName());
			order.setCustomer(c);
			
			List<OrderItem>orderItems=ord.getOrderItems();
			
			OrderItem ordItem=new OrderItem();
			ordItem.setOrder(order);
			
			for(OrderItem o:orderItems) {
				Product p=productRepository.getOne(o.getProduct().getProductId());
				ordItem.setProduct(p);
				ordItem.setQuantity(o.getQuantity());
			}
			
			orderItemRepositry.save(ordItem);
			orderRepository.save(order);

			return "Saved Succesfully";
		}
		return "Problem in saving order";

		
    }

}
