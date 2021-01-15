package com.pnc.customer.transaction.common;



public class Transaction {


    public Transaction(Integer id, TransactionType transactionType, Float amount) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    private Integer id;
    private TransactionType transactionType;
    private Float amount;




    public TransactionType getTransacitonType() {
        return transactionType;
    }

    public Transaction setTransacitonType(TransactionType transacitonType) {
        this.transactionType = transacitonType;
        return this;
    }

    public Float getAmount() {
        return amount;
    }

    public Transaction setAmount(Float amount) {
        this.amount = amount;
        return this;
    }


    public Integer getId() {
        return id;
    }

    public Transaction setId(Integer id) {
        this.id = id;
        return this;
    }

}
