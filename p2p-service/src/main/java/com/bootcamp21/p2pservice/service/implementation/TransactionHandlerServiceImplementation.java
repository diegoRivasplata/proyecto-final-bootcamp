package com.bootcamp21.p2pservice.service.implementation;

import com.bootcamp21.p2pservice.entity.Transaction;
import com.bootcamp21.p2pservice.repository.TransactionRepository;
import com.bootcamp21.p2pservice.service.TransactionHandlerService;
import com.bootcamp21.p2pservice.service.events.TransactionEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionHandlerServiceImplementation implements TransactionHandlerService {

    @Autowired
    private TransactionRepository _transactionRepository;

    private final TransactionEventsService _transactionEventsService;

    public TransactionHandlerServiceImplementation(TransactionEventsService transactionEventsService) {
        super();
        this._transactionEventsService = transactionEventsService;
    }

    @Override
    public Transaction doTransaction(Transaction transaction) {
        _transactionRepository.save(transaction);
        System.out.println("Received " + transaction);
        this._transactionEventsService.publish(transaction);
        return transaction;
    }
}
