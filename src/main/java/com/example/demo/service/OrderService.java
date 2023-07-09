package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Orderr;

public interface OrderService {

	public Orderr createOrder(Orderr order,int cid,int pid);
	public List<Orderr> showOrdersList(int id);
}
