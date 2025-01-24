package com.sr.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sr.order_service.entity.OrderEntity;
import com.sr.order_service.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	 @Autowired
	    OrderService orderService;

	    @PostMapping
	    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
	        OrderEntity savedOrder = orderService.addOrder(order);
	        return ResponseEntity.ok(savedOrder);
	    }

	    @GetMapping
	    public ResponseEntity<List<OrderEntity>> getAllOrders() {
	        List<OrderEntity> orders = orderService.getAllOrders();
	        return ResponseEntity.ok(orders);
	    }

	    @GetMapping("/{orderId}")
	    public ResponseEntity<OrderEntity> getOrderById(@PathVariable int orderId) {
	        OrderEntity order = orderService.getOrderById(orderId);
	        return ResponseEntity.ok(order);
	    }

	    // Get orders by User ID
//	    @GetMapping("/user/{userId}")
//	    public ResponseEntity<List<OrderEntity>> getOrdersByUserId(@PathVariable int userId) {
//	        List<OrderEntity> orders = orderService.getOrdersByUserId(userId);
//	        return ResponseEntity.ok(orders);
//	    }

	    @PutMapping
	    public ResponseEntity<OrderEntity> updateOrder(@RequestBody OrderEntity editOrder) {
	        OrderEntity updatedOrder = orderService.updateOrder(editOrder);
	        return ResponseEntity.ok(updatedOrder);
	    }

	    @DeleteMapping("/{orderId}")
	    public ResponseEntity<String> deleteOrder(@PathVariable int orderId) {
	        orderService.deleteOrderById(orderId);
	        return ResponseEntity.ok("Order deleted successfully!");
	    }
}
