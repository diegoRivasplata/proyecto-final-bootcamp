package com.bootcamp21.p2pservice.repository;

import com.bootcamp21.p2pservice.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
