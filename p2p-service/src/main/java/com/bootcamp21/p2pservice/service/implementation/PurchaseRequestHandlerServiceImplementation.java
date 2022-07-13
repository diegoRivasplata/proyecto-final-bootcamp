package com.bootcamp21.p2pservice.service.implementation;

import com.bootcamp21.p2pservice.entity.PurchaseRequest;
import com.bootcamp21.p2pservice.repository.PurchaseRequestRepository;
import com.bootcamp21.p2pservice.service.PurchaseRequestHandlerService;
import com.bootcamp21.p2pservice.service.events.PurchasRequestEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRequestHandlerServiceImplementation implements PurchaseRequestHandlerService {

    @Autowired
    private PurchaseRequestRepository _repository;

    private final PurchasRequestEventsService _purchasRequestEventsService;

    public PurchaseRequestHandlerServiceImplementation(PurchasRequestEventsService purchasRequestEventsService){
        super();
        _purchasRequestEventsService = purchasRequestEventsService;
    }

    @Override
    public PurchaseRequest createPurchaseRequest(PurchaseRequest purchaseRequest) {
        _repository.save(purchaseRequest);
        System.out.println("Received " + purchaseRequest);
        this._purchasRequestEventsService.publish(purchaseRequest);
        return purchaseRequest;
    }
}
