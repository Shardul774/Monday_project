package com.banking.customer.controller;

import com.banking.customer.model.KycDocument;
import com.banking.customer.service.KycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kyc")
public class KycController {

    @Autowired
    private KycService kycService;

    @PostMapping
    public ResponseEntity<KycDocument> submitKyc(@RequestBody KycDocument kycDocument) {
        return new ResponseEntity<>(kycService.submitDocument(kycDocument), HttpStatus.CREATED);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<KycDocument> getKycStatus(@PathVariable Long customerId) {
        return kycService.getKycStatusByCustomerId(customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}