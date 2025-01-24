package com.sr.order_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sr.order_service.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity,Integer>{

}
