package com.banking.uiservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "api-gateway", contextId = "transactionClient")
public interface TransactionClient {
    @GetMapping("/api/transactions/account/{accountId}")
    List<Object> getTransactionsByAccountId(@PathVariable("accountId") Long accountId);
}