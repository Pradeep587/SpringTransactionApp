package com.pnc.customer.transaction.dao;

import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface TransactionRepositoryCustom<AccountInfo, Integer> {
    List<AccountInfo> retrieveTransactions(String accNo, String type, Date startdate, Date enddate);
}
