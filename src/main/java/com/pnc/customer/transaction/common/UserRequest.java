package com.pnc.customer.transaction.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserRequest {
    private String accountNumber;
    private String startDate;
    private String endDate;
    private String transactionType;
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public UserRequest setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public UserRequest setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public UserRequest setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }



    public String getTransactionType() {
        return transactionType;
    }

    public UserRequest setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }
}
