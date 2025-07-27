package com.banking.uiservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Using Object because KycDocument class is not in this project
@FeignClient(name = "api-gateway", contextId = "kycClient")
public interface KycClient {
    @GetMapping("/api/kyc/customer/{customerId}")
    Object getKycStatusByCustomerId(@PathVariable("customerId") Long customerId);
}