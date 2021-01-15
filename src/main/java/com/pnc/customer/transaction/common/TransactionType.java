package com.pnc.customer.transaction.common;

import javax.persistence.Enumerated;

public enum TransactionType {
    WITHDRAW("withdraw"),
    DEPOSIT("deposit");


    private String value;

    TransactionType(String value) { this.value = value; }

    public String getValue() { return value; }
    public String getName() {
        return name();
    }

    public static TransactionType fromValue(String v){
        for (TransactionType c : TransactionType.values()) {
            if (c.value.equalsIgnoreCase(v)) {
                return c;
            }
        }
        return null;
    }
}
