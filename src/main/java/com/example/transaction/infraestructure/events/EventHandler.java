package com.example.transaction.infraestructure.events;

public interface EventHandler {
    void on(TransactionEvent event);
}
