package com.bootcamp21.p2pservice.service.events;

import com.bootcamp21.p2pservice.entity.Bootcoin;
import com.bootcamp21.p2pservice.entity.Transaction;
import com.bootcamp21.p2pservice.events.Event;
import com.bootcamp21.p2pservice.events.EventType;
import com.bootcamp21.p2pservice.events.producer.BootcoinUpdatedEvent;
import com.bootcamp21.p2pservice.events.producer.TransactionDoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class TransactionEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.transaction.name:transaction}")
    private String topicTransaction;

    public void publish(Transaction transaction) {

        TransactionDoneEvent created = new TransactionDoneEvent();
        created.setData(transaction);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicTransaction, created);
    }

}
