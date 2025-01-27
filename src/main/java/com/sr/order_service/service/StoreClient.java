package com.sr.order_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import com.sr.order_service.pojo.StorePojo;

import com.sr.order_service.pojo.StorePojo;

@FeignClient(name = "stores-service", url = "http://localhost:7001/api")
public interface StoreClient {
    @GetMapping("/stores/b/{sid}")
    StorePojo getStoreById(@PathVariable int sid);
} 
