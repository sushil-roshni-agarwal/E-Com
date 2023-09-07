package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Orderr;

public interface OrderService {

	public Orderr createOrder(int customerId, List<Integer> productIds);
}
