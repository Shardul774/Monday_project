package com.banking.customer.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.math.BigDecimal;

@FeignClient(name = "account-service")
public interface AccountClient {
    // This calls the new endpoint we created in the account-service
    @PutMapping("/api/accounts/{accountId}/balance")
    void updateAccountBalance(@PathVariable Long accountId, @RequestBody BigDecimal amount);
}