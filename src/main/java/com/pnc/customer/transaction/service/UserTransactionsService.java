package com.pnc.customer.transaction.service;




import com.pnc.customer.transaction.common.TransactionDetails;

import java.util.Date;
import java.util.concurrent.CompletionStage;

public interface UserTransactionsService {


    CompletionStage<TransactionDetails> retrieveTransactiondetails(String accountNumber, String type, Date StartDate, Date endDate);


}
