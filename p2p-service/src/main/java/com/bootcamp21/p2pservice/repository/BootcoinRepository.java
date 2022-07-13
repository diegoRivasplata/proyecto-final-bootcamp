package com.bootcamp21.p2pservice.repository;

import com.bootcamp21.p2pservice.entity.Bootcoin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcoinRepository extends MongoRepository<Bootcoin, String> {
}
