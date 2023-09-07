package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Orderr createOrder(
			@RequestParam int customerId,
            @RequestParam List<Integer> productIds) {
		return orderService.createOrder(customerId, productIds);
	}
}
