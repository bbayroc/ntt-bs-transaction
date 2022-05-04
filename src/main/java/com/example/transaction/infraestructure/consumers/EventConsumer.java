package com.example.transaction.infraestructure.consumers;

import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import com.example.transaction.infraestructure.events.TransactionEvent;

public interface EventConsumer {
    void consume(@Payload TransactionEvent event, Acknowledgment ack);
}
