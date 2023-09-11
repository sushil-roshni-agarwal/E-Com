package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OrderItem;


public interface OrderItemRepositry extends JpaRepository<OrderItem,Integer>{
	
}


