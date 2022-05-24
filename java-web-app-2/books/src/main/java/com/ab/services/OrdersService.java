package com.ab.services;

import java.util.List;

import com.ab.daos.OrdersDAO;
import com.ab.models.Order;

public class OrdersService {
	
	
private OrdersDAO ordersDAO;
	

	
	public OrdersService(OrdersDAO ordersDAO) {
		
		this.ordersDAO = ordersDAO;
	}
	
	
	public List<Order> getCustomerOrders(int customer_id) {
		
		return this.ordersDAO.findCustomerOrders(customer_id);
		
		
	}

}
