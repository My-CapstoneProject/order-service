package com.sr.order_service.pojo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderProductPojo {
	
public int orderProductId;
	
	public int orderId;

	public int productId;

	public int salesQuantity;
	
	private ProductPojo productPojo;
	
	

}
