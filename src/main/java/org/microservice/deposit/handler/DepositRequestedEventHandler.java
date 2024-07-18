package org.microservice.deposit.handler;

import lombok.extern.slf4j.Slf4j;
import org.microservice.core.DepositRequestedEvent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(topics = "deposit-money-topic", containerFactory = "kafkaListenerContainerFactory")
public class DepositRequestedEventHandler {
    @KafkaHandler
    public void handler(DepositRequestedEvent depositRequestedEvent) {
        log.info("Received a new deposit event: {}", depositRequestedEvent.getAmount());
    }
}
