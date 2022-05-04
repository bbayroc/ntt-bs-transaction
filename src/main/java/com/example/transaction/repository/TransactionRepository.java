package com.example.transaction.repository;

import com.example.transaction.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, Long> {
    List<Transaction> findByIdaccount (String idaccount);


}
