package com.sr.order_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="order_details")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	public int orderId;
	
	@Column(name="order_status")
	public String orderStatus;
	
	@Column(name="order_date")
	public LocalDate orderDate;
	
	@Column(name="order_user_id")
	public int orderUserId;
	
	@Column(name="order_store_id")
	public int orderStoreId;

}
