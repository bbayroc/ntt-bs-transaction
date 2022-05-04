package com.example.transaction.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Transaction")
@Data
public class Transaction {
    @Id
    @Transient
    public static final String SEQUENCE_NAME = "transaction_sequence";
    private long id;
    private String idaccount;
    private String transactiontype;
    private double amount;
    private String created;
    private double appliedcomission;

}
