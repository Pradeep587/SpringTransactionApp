package com.pnc.customer.transaction.dao;


import com.pnc.customer.transaction.common.TransactionType;
import com.pnc.customer.transaction.common.UserRequest;
import com.pnc.customer.transaction.model.AccountInfo;
import com.pnc.customer.transaction.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionInfoRepository extends CrudRepository<AccountInfo, Integer>,TransactionRepositoryCustom {

   }
