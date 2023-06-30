package org.mybatis.jpetstore.service;

import java.util.List;

import org.mybatis.jpetstore.domain.Order;

public interface OrderService {
	
	void insertOrder(Order order);
	
	Order getOrder(int orderId);
	
	List<Order> getOrdersByUsername(String username);
	
	int getNextId(String name);

}
