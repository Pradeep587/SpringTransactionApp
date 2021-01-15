package com.pnc.customer.transaction.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class AccountInfo {
    @Id
    @Column(name="account_number")
    private String accountNumber;
    private Float balance;
    private Date lastUpdatedTimeStamp;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="account_number",referencedColumnName = "account_number")
    private List<Transactions> transactions;

    public AccountInfo() {
    }

    public AccountInfo(Float balance, Date lastUpdatedTimeStamp, List<Transactions> transactions) {
        this.balance = balance;
        this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
        this.transactions = transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountInfo setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Float getBalance() {
        return balance;
    }

    public AccountInfo setBalance(Float balance) {
        this.balance = balance;
        return this;
    }

    public Date getLastUpdatedTimeStamp() {
        return lastUpdatedTimeStamp;
    }

    public AccountInfo setLastUpdatedTimeStamp(Date lastUpdatedTimeStamp) {
        this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
        return this;
    }


    public List<Transactions> getTransactions() {
        return transactions;
    }

    public AccountInfo setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
        return this;
    }
}
