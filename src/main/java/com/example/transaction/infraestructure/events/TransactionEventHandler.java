package com.example.transaction.infraestructure.events;

import com.example.transaction.entity.Transaction;
import com.example.transaction.repository.TransactionRepository;
import com.example.transaction.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TransactionEventHandler implements EventHandler{
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void on(TransactionEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        Transaction transaction = new Transaction();

        transaction.setId(sequenceGeneratorService.generateSequence(Transaction.SEQUENCE_NAME));
        transaction.setCreated(LocalDateTime.now().format(formatter));
        transaction.setTransactiontype(event.getTransactiontype());
        transaction.setAmount(event.getAmount());
        transaction.setAppliedcomission(event.getAppliedcomission());
        transaction.setIdaccount(event.getIdaccount());

        transactionRepository.save(transaction);

    }
}
