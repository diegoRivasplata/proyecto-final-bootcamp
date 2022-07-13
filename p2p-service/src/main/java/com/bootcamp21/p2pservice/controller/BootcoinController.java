package com.bootcamp21.p2pservice.controller;

import com.bootcamp21.p2pservice.entity.Bootcoin;
import com.bootcamp21.p2pservice.service.implementation.BootcoinHandlerServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bootcoin")
public class BootcoinController {

    private final BootcoinHandlerServiceImplementation _bootcoinService;

    public BootcoinController(BootcoinHandlerServiceImplementation bootcoinService){
        super();
        this._bootcoinService=bootcoinService;
    }

    @PostMapping
    public ResponseEntity<?> updateBootcoin(@RequestBody Bootcoin bootcoin) {
        try{
            Bootcoin newBootcoinValue = this._bootcoinService.updateBootcoin(bootcoin);
            return new ResponseEntity<>(newBootcoinValue, HttpStatus.CREATED);
        }
        catch (Exception err){
            return new ResponseEntity<>(err.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}



























