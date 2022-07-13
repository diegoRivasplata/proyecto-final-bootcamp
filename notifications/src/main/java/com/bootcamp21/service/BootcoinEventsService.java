package com.bootcamp21.service;

import com.bootcamp21.events.producer.BootcoinUpdatedEvent;
import com.bootcamp21.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootcoinEventsService {

    @KafkaListener(
            topics = "${topic.bootcoin.name:bootcoins}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(BootcoinUpdatedEvent.class)) {
            BootcoinUpdatedEvent bootcoinUpdatedEvent = (BootcoinUpdatedEvent) event;
            log.info("Received bootcoin updated value event .... with Id={}, data={}",
                    bootcoinUpdatedEvent.getId(),
                    bootcoinUpdatedEvent.getData().toString());
        }

    }
}
