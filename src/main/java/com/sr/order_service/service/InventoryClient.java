package com.sr.order_service.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sr.order_service.pojo.OrderProductPojo;

@FeignClient(name = "inventory-service", url = "http://localhost:7002")
public interface InventoryClient {
    @PostMapping("/api/update-sales")
    void updateSales(@RequestBody List<OrderProductPojo> orderProducts);
}
