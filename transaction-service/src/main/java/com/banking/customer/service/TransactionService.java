package com.banking.customer.service;

import com.banking.customer.dao.TransactionRepository;
import com.banking.customer.model.Transaction;
import com.banking.customer.model.TransactionType;
import com.banking.customer.proxy.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountClient accountClient;

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        transaction.setTimestamp(LocalDateTime.now());
        
        BigDecimal amountToUpdate = transaction.getType() == TransactionType.CREDIT 
            ? transaction.getAmount() 
            : transaction.getAmount().negate();

        accountClient.updateAccountBalance(transaction.getAccountId(), amountToUpdate);

        return transactionRepository.save(transaction);
    }
    
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}