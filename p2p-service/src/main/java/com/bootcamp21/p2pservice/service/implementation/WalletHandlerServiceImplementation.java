package com.bootcamp21.p2pservice.service.implementation;

import com.bootcamp21.p2pservice.entity.Wallet;
import com.bootcamp21.p2pservice.repository.WalletRepository;
import com.bootcamp21.p2pservice.service.WalletHandlerService;
import com.bootcamp21.p2pservice.service.events.WalletEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletHandlerServiceImplementation implements WalletHandlerService {

    @Autowired
    private WalletRepository _repository;

    private final WalletEventsService _walletEventsService;

    public WalletHandlerServiceImplementation(WalletEventsService walletEventsService) {
        super();
        this._walletEventsService = walletEventsService;
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        _repository.save(wallet);
        System.out.println("Received " + wallet);
        this._walletEventsService.publish(wallet);
        return wallet;
    }
}
