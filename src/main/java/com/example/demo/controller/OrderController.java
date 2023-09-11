package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orderr;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("/createOrder")
	public String createOrder(
			@RequestBody Orderr ord) {
		System.out.println(ord.getCustomer().getCustUserName());
		return orderService.createOrder(ord);
	}
}
