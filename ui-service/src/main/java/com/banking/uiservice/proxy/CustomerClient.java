package com.banking.uiservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

// ✅ Add the contextId
@FeignClient(name = "api-gateway", contextId = "customerClient")
public interface CustomerClient {
    
    @GetMapping("/api/customers")
    List<Object> getAllCustomers();
}