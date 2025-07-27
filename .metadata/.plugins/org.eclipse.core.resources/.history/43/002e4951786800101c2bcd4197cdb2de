package com.banking.customer.dao;

import com.banking.customer.model.KycDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface KycRepository extends JpaRepository<KycDocument, Long> {
    Optional<KycDocument> findByCustomerId(Long customerId);
}