package com.bootcamp21.p2pservice.controller;

import com.bootcamp21.p2pservice.entity.PurchaseRequest;
import com.bootcamp21.p2pservice.service.implementation.PurchaseRequestHandlerServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase-request")
public class PurchaseRequestController {

    private final PurchaseRequestHandlerServiceImplementation _purchaseService;

    public PurchaseRequestController(PurchaseRequestHandlerServiceImplementation purchaseService){
        super();
        this._purchaseService = purchaseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createPurchaseRequest(@RequestBody PurchaseRequest purchaseRequest){
        try{
            PurchaseRequest newPurchaseRequest = this._purchaseService.createPurchaseRequest(purchaseRequest);
            return new ResponseEntity<>(newPurchaseRequest, HttpStatus.CREATED);
        }
        catch (Exception err){
            return new ResponseEntity<>(err.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
