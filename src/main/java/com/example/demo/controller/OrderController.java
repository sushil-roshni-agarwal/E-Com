package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orderr;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	@PostMapping("/createOrder/{custid}/{prodid}")
	public Orderr createOrder(@PathVariable int custid,@PathVariable int prodid ,@RequestBody Orderr orderJson)
	{
		return orderService.createOrder(orderJson, custid, prodid);
		}
	@GetMapping("/Order/{id}")
	public List<Orderr> showOrder(@PathVariable int id){
		
		return orderService.showOrdersList(id);
		
	}

}
