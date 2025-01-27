package com.sr.order_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.sr.order_service.pojo.OrderPojo;
import com.sr.order_service.pojo.StorePojo;
import com.sr.order_service.service.OrderService;
import com.sr.order_service.service.StoreClient;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	 @Autowired
	    OrderService orderService;
	 
	 @Autowired
	    StoreClient storeClient;

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
//	    @GetMapping("/order/{orderId}")
//	    public ResponseEntity<List<OrderEntity>> getOrdersByStoreId(@PathVariable int userId) {
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
	    
	    @GetMapping("/a/{oid}")
		public ResponseEntity<OrderPojo> getAOrder(@PathVariable int oid) {
		    Optional<OrderEntity> orderOptional = orderService.getAOrder(oid);
		    
		    if (orderOptional.isPresent()) {
		        OrderEntity order = orderOptional.get();  // Unwrap the Optional
		        
		        OrderPojo orderPojo = new OrderPojo();
		        
		        // Now use Feign client to fetch department by departmentI
		        StorePojo store = storeClient.getStoreById(order.getOrderStoreId());

		        
//		        StorePojo store = storeClient.getStoreById(inventory.getInStoreId());
		        
		        
		        // Set the department to the employee
		        orderPojo.setOrderId(order.getOrderId());
		        orderPojo.setOrderStatus(order.getOrderStatus());
		        orderPojo.setOrderDate(order.getOrderDate());
		        orderPojo.setOrderUserId(order.getOrderUserId());
		        orderPojo.setOrderStoreId(order.getOrderStoreId());
		        orderPojo.setStorePojo(store);
		        
		        
		        return new ResponseEntity<>(orderPojo, HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Employee not found
		    }
		}
}


