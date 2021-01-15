package com.pnc.customer.transaction.model;

import com.pnc.customer.transaction.common.TransactionType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transactions {

    @Id
    @GeneratedValue
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private Float amount;
    private Date transactionTime;

    public Transactions() {
        super();
    }

    public Transactions(Integer id, TransactionType type, Float amount, Date transactionTime) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.transactionTime = transactionTime;
    }

    public Transactions( TransactionType type, Date transactionTime) {

        this.type = type;
        this.transactionTime = transactionTime;
    }

    public Float getAmount() {
        return amount;
    }

    public Transactions setAmount(Float amount) {
        this.amount = amount;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Transactions setId(Integer id) {
        this.id = id;
        return this;
    }


    public TransactionType getType() {
        return type;
    }

    public Transactions setType(TransactionType type) {
        this.type = type;
        return this;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public Transactions setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
        return this;
    }


}
