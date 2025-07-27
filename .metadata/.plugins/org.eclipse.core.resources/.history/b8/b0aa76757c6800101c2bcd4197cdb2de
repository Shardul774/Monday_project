package com.banking.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.customer.model.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Custom method to find all accounts for a given customer
    List<Account> findByCustomerId(Long customerId);
}