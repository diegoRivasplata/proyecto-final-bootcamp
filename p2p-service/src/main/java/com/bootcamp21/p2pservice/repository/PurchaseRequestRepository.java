package com.bootcamp21.p2pservice.repository;

import com.bootcamp21.p2pservice.entity.PurchaseRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseRequestRepository extends MongoRepository<PurchaseRequest, String> {
}
