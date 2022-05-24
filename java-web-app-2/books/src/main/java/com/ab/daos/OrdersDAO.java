package com.ab.daos;

import java.util.List;
import com.ab.models.Order;

public interface OrdersDAO {
	
	public List<Order> findCustomerOrders(int customer_id);
	
	


}
