package com.bootcamp21.p2pservice.service.events;

import com.bootcamp21.p2pservice.entity.Wallet;
import com.bootcamp21.p2pservice.events.Event;
import com.bootcamp21.p2pservice.events.EventType;
import com.bootcamp21.p2pservice.events.producer.WalletCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class WalletEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.wallet.name:wallet}")
    private String topicWallet;

    public void publish(Wallet wallet) {

        WalletCreatedEvent created = new WalletCreatedEvent();
        created.setData(wallet);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicWallet, created);
    }
}
