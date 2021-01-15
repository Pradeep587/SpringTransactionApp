package com.pnc.customer.transaction.common;

import java.io.Serializable;
import java.util.List;

public class TransactionDetails implements Serializable, Response {

    private String accountNumber;
    private Float balance;

    public TransactionDetails() {
    }

    public TransactionDetails(String accountNumber, Float balance, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = transactions;
    }

    private List<Transaction> transactions;

    public String getAccountNumber() {
        return accountNumber;
    }

    public TransactionDetails setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public TransactionDetails setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }
    public Float getBalance() {
        return balance;
    }

    public TransactionDetails setBalance(Float balance) {
        this.balance = balance;
        return this;
    }



}
