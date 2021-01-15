package com.pnc.customer.transaction.dao;

import com.pnc.customer.transaction.model.AccountInfo;
import com.pnc.customer.transaction.model.Transactions;
import io.micrometer.core.instrument.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@SuppressWarnings("unchecked")
public class TransactionRepositoryCustomImpl implements TransactionRepositoryCustom<AccountInfo, Integer>{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AccountInfo> retrieveTransactions(String accNo, String type, Date startDate, Date endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM account_info acct join transactions trans on acct.account_number=trans.account_number ");

        if (StringUtils.isNotEmpty(accNo)) {
                sb.append(" WHERE acct.account_number = '" + accNo + "'");
        }
        if ( StringUtils.isNotEmpty(type)) {
                sb.append(" and  trans.type = '" + type + "'");
        }
        addDateParameters(startDate, endDate, sb);

        Query query = entityManager.createNativeQuery(sb.toString(),AccountInfo.class);

        return query.getResultList();
    }

    private void addDateParameters(Date startDate, Date endDate, StringBuilder sb) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (null != startDate ||  null != endDate) {
            if(null== startDate && null != endDate){
                sb.append(" and  trans.transaction_time <=  TO_DATE('" + formatter.format(endDate) + "','yyyy-MM-dd')");
            }else if(null== endDate && null != startDate){
                sb.append(" and  trans.transaction_time >=  TO_DATE('" + formatter.format(startDate) + "','yyyy-MM-dd')");
            }else {
                sb.append(" and  trans.transaction_time between TO_DATE('"+formatter.format(startDate)+"','yyyy-MM-dd') AND TO_DATE('"+formatter.format(endDate)+"','yyyy-MM-dd')");
            }
        }
    }


}
