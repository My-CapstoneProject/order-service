package com.sr.order_service.pojo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderProductPojo {
	
private int orderProductId;
	
	private int orderId;

	private int productId;

	private int salesQuantity;
	@JsonIgnore
	private ProductPojo productPojo;
	
	

}
