package com.pnc.customer.transaction.service;



import com.pnc.customer.transaction.common.Transaction;
import com.pnc.customer.transaction.common.TransactionDetails;
import com.pnc.customer.transaction.common.TransactionType;
import com.pnc.customer.transaction.dao.TransactionInfoRepository;
import com.pnc.customer.transaction.model.AccountInfo;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Service
@SuppressWarnings("unchecked")
public class UserTransactionsServiceImpl implements UserTransactionsService {

    @Autowired
    public TransactionInfoRepository transInfoRepo;

    @Override
    public CompletionStage<TransactionDetails> retrieveTransactiondetails(String accNo, String type, Date startDate, Date endDate) {


        List<AccountInfo> transInfo= transInfoRepo.retrieveTransactions(accNo,type,startDate,endDate);
        TransactionDetails transactionDetails=null;
        if(transInfo.size() >0) {
            transactionDetails=new TransactionDetails();
            AccountInfo accontDetails = transInfo.get(0);
            transactionDetails.setAccountNumber(accontDetails.getAccountNumber());
            if (StringUtils.isEmpty(type) && null == startDate && null == endDate) {
                return CompletableFuture.completedFuture(new TransactionDetails(accontDetails.getAccountNumber(), accontDetails.getBalance(), null));

            }

            List<Transaction> transactionList = new ArrayList<Transaction>();
            accontDetails.getTransactions().stream().forEach(entry -> {
                transactionList.add(new Transaction(entry.getId(), TransactionType.valueOf(entry.getType().getName()), entry.getAmount()));
            });
            transactionDetails.setBalance(accontDetails.getBalance());
            transactionDetails.setTransactions(transactionList);

        }
       return CompletableFuture.completedFuture(transactionDetails);
    }

}