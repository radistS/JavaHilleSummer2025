package com.exchanger.repository;

import com.exchanger.entity.TransactionEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {

    Optional<TransactionEntity> findTransactionByIdAndSender(UUID transactionId, String phone);
}
