package com.example.transaction.controller;

import com.example.transaction.service.SequenceGeneratorService;
import com.example.transaction.entity.Transaction;
import com.example.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping
    public Transaction save(@RequestBody Transaction transaction) {
        transaction.setId(sequenceGeneratorService.generateSequence(Transaction.SEQUENCE_NAME));

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        transaction.setCreated(LocalDateTime.now().format(formatter));

        return transactionRepository.save(transaction);
    }

    @GetMapping("/{idaccount}")
    public List<Transaction> find(@PathVariable String idaccount) {

        return transactionRepository.findByIdaccount(idaccount);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        transactionRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable long id, @RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

}
