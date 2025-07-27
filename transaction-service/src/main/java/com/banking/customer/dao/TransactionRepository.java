package com.banking.customer.dao;

import com.banking.customer.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // ✅ Find by accountId, not customerId
    List<Transaction> findByAccountId(Long accountId);

}