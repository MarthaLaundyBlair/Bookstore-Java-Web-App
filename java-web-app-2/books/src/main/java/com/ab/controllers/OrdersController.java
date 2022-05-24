package com.ab.controllers;

import java.util.List;

import com.ab.models.Order;
import com.ab.services.OrdersService;

public class OrdersController {

	private OrdersService ordersService;

	public OrdersController(OrdersService ordersService) {

		this.ordersService = ordersService;
	}



	public List<Order> getCustomerOrders(int customer_id) {

		return this.ordersService.getCustomerOrders(customer_id);

	}

}
