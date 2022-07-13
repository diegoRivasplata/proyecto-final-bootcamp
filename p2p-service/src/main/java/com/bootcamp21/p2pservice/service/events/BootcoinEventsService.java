package com.bootcamp21.p2pservice.service.events;

import com.bootcamp21.p2pservice.entity.Bootcoin;
import com.bootcamp21.p2pservice.events.Event;
import com.bootcamp21.p2pservice.events.EventType;
import com.bootcamp21.p2pservice.events.producer.BootcoinUpdatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class BootcoinEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.bootcoin.name:bootcoins}")
    private String topicBootcoin;

    public void publish(Bootcoin bootcoin) {

        BootcoinUpdatedEvent created = new BootcoinUpdatedEvent();
        created.setData(bootcoin);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicBootcoin, created);
    }
}
