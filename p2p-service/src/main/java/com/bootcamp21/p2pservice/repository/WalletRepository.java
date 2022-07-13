package com.bootcamp21.p2pservice.repository;

import com.bootcamp21.p2pservice.entity.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<Wallet, String> {
}
