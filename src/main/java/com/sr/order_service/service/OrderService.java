package com.sr.order_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.order_service.dao.OrderRepo;
import com.sr.order_service.entity.OrderEntity;

@Service
public class OrderService {
	@Autowired
    OrderRepo orderRepository;
	
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
