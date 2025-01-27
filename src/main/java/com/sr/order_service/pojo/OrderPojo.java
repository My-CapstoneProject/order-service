package com.sr.order_service.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderPojo {
	
	public int orderId;
	
	public String orderStatus;

	public LocalDate orderDate;

	public int orderUserId;

	public int orderStoreId;
	
	private StorePojo storePojo;

	public StorePojo getStorePojo() {
	    return storePojo;
	}

	public void setStorePojo(StorePojo storePojo) {
	    this.storePojo = storePojo;
	}


}
