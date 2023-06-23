package org.mybatis.jpetstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.jpetstore.domain.Order;

@Mapper
public interface OrderMapper {

	List<Order> getOrdersByUsername(String username);

	Order getOrder(int orderId);

	void insertOrder(Order order);

	void insertOrderStatus(Order order);

}
