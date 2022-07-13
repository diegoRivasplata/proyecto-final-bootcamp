package com.bootcamp21.p2pservice.controller;

import com.bootcamp21.p2pservice.entity.Wallet;
import com.bootcamp21.p2pservice.service.implementation.WalletHandlerServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletHandlerServiceImplementation _walletService;

    public WalletController(WalletHandlerServiceImplementation walletService){
        super();
        this._walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<?> createWallet(@RequestBody Wallet wallet){
        try{
            Wallet newWallet = this._walletService.createWallet(wallet);
            return new ResponseEntity<>(newWallet, HttpStatus.CREATED);
        }
        catch (Exception err){
            return new ResponseEntity<>(err.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
