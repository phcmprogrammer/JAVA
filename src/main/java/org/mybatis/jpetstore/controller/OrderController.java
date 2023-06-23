package org.mybatis.jpetstore.controller;

import java.util.List;

import org.mybatis.jpetstore.domain.Order;
import org.mybatis.jpetstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST JpetStore")
@RestController
@RequestMapping
public class OrderController {

	@Autowired
	private OrderService orderService;

	@ApiOperation(value = "Cria um pedido")
	@PostMapping(value = "/orders")
	public void insertOrder(@RequestBody Order order) {
		orderService.insertOrder(order);
	}

	@ApiOperation(value = "Seleciona o pedido pelo id do pedido")
	@GetMapping(value = "/orders/{orderId}")
	public Order getOrder(@PathVariable int orderId) {
		Order obj = orderService.getOrder(orderId);
		return obj;
	}

	@ApiOperation(value = "Retorna a lista de pedidos de um usuário pelo username")
	@GetMapping(value = "/orders")
	public ResponseEntity<List<Order>> getOrdersByUsername(String username) {
		List<Order> orders = orderService.getOrdersByUsername(username);
		return ResponseEntity.ok(orders);
	}

	@ApiOperation(value = "Gera o nextID")
	@GetMapping(value = "/sequence/{name}")
	public int getNextId(@PathVariable String name) {
		return orderService.getNextId(name);
	}

}