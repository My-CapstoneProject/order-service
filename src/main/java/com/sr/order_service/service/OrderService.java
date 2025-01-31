package com.sr.order_service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.order_service.dao.OrderRepo;
import com.sr.order_service.entity.OrderEntity;

@Service
public class OrderService {
	@Autowired
    OrderRepo orderRepository;
	
	 @Autowired
	    KeenService keenService;

	    public OrderEntity completeOrder(OrderEntity order) {
	        OrderEntity savedOrder = orderRepository.save(order);

	        // Log order details to Keen.io
	        Map<String, Object> orderData = new HashMap<>();
	        orderData.put("orderId", savedOrder.getOrderId());
	        orderData.put("orderStatus", savedOrder.getOrderStatus());
	        orderData.put("orderDate", savedOrder.getOrderDate());
	        orderData.put("orderStoreId", savedOrder.getOrderStoreId());
	        orderData.put("orderUserId", savedOrder.getOrderUserId());
	        orderData.put("totalAmount", savedOrder.getTotalAmount()); // Ensure OrderEntity has this field

	        keenService.logEvent("orders", orderData);

	        return savedOrder;
	    }
	
    public OrderEntity addOrder(OrderEntity neworder) {
        return orderRepository.saveAndFlush(neworder);
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity getOrderById(int orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
    }
//
//    public List<ProductEntity> getProductsByUserId(int userId) {
//        return productRepository.findByUserId(userId);
//    }

    public Optional<OrderEntity> getAOrder(int orderId) {
		return orderRepository.findById(orderId);
	}
    
    public OrderEntity updateOrder(OrderEntity editorder) {
        return orderRepository.save(editorder);
    }

    public void deleteOrderById(int orderId) {
        orderRepository.deleteById(orderId);
    }

}
