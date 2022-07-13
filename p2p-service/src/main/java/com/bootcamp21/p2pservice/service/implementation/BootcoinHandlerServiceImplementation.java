package com.bootcamp21.p2pservice.service.implementation;

import com.bootcamp21.p2pservice.entity.Bootcoin;
import com.bootcamp21.p2pservice.repository.BootcoinRepository;
import com.bootcamp21.p2pservice.service.BootcoinHandlerService;
import com.bootcamp21.p2pservice.service.events.BootcoinEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootcoinHandlerServiceImplementation implements BootcoinHandlerService {

    @Autowired
    private BootcoinRepository _repository;

    private final BootcoinEventsService _bootcoinEventsService;

    public BootcoinHandlerServiceImplementation(BootcoinEventsService bootcoinEventsService) {
        super();
        this._bootcoinEventsService = bootcoinEventsService;
    }

    @Override
    public Bootcoin updateBootcoin(Bootcoin bootcoin) {
        _repository.save(bootcoin);
        System.out.println("Received " + bootcoin);
        this._bootcoinEventsService.publish(bootcoin);
        return bootcoin;
    }
}



































