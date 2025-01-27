package com.sr.order_service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StorePojo {
    private int storeId;         // Corresponds to store_id
    private String storeName;    // Corresponds to store_name
    private int storeRegionId;   // Corresponds to store_region_id
    private int storeUserId;     // Corresponds to store_user_id
    private String regionName;   // Corresponds to region_name
}


