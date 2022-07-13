package com.bootcamp21.p2pservice.service;

import com.bootcamp21.p2pservice.entity.Transaction;

public interface TransactionHandlerService {
    Transaction doTransaction(Transaction transaction);
}
