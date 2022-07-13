package com.bootcamp21.p2pservice.service.events;

import com.bootcamp21.p2pservice.entity.PurchaseRequest;
import com.bootcamp21.p2pservice.events.Event;
import com.bootcamp21.p2pservice.events.EventType;
import com.bootcamp21.p2pservice.events.producer.BootcoinUpdatedEvent;
import com.bootcamp21.p2pservice.events.producer.PurchaseRequestCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class PurchasRequestEventsService {

    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.purchasseRequest.name:purchasRequest}")
    private String topicPurchaseRequest;

    public void publish(PurchaseRequest purchaseRequest){
        PurchaseRequestCreatedEvent created = new PurchaseRequestCreatedEvent();
        created.setData(purchaseRequest);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicPurchaseRequest, created);
    }
}
