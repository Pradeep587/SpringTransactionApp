package com.pnc.customer.transaction.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pnc.customer.transaction.common.*;
import com.pnc.customer.transaction.common.Error;
import com.pnc.customer.transaction.service.UserTransactionsService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@RestController
public class CxTransactionController {

    @Autowired
    private UserTransactionsService userTransactionsService;

    @PostMapping(value = "/transactions",consumes= "application/json",produces =  "application/json")
    public CompletionStage<ResponseEntity<Response>> retrieveTransactions(@RequestBody UserRequest userRequest, @RequestHeader(value="applicationId", required=true) String applicationId, @RequestHeader(value="token", required=true) String token) throws JsonProcessingException {
        if (StringUtils.isEmpty(userRequest.getAccountNumber())) {
            return CompletableFuture.completedFuture(new ResponseEntity<>(new Error("Invalid Account number",
                    "Bad Request", "400"), HttpStatus.BAD_REQUEST));
        }

        /*if(!StringUtils.isEmpty(applicationId) && "PNC".equalsIgnoreCase(applicationId) ){
            return CompletableFuture.completedFuture(new ResponseEntity<>(new Error("missing headers",
                    "Bad Request", "400"), HttpStatus.BAD_REQUEST));
        }*/

        Date startDate=DateFormatter.convertString(userRequest.getStartDate());
        Date endDate=DateFormatter.convertString(userRequest.getEndDate());

        if (null!= startDate && null!= endDate && (startDate.compareTo(endDate) ==0 || startDate.compareTo(endDate) >0)) {
            return CompletableFuture.completedFuture(new ResponseEntity<>(new Error("Invalid Date Range",
                    "Bad Request", "400"), HttpStatus.BAD_REQUEST));
        }

        if((!StringUtils.isEmpty(userRequest.getTransactionType())) && null == TransactionType.fromValue(userRequest.getTransactionType())){
            return CompletableFuture.completedFuture(new ResponseEntity<>(new Error("Invalid TransactionType",
                    "Bad Request", "400"), HttpStatus.BAD_REQUEST));
        }

        return userTransactionsService.retrieveTransactiondetails(userRequest.getAccountNumber(), userRequest.getTransactionType(), startDate,endDate)
                .thenApply(response -> {
                    if (response == null) {
                        Error error = new Error("Details not found for the account=" + userRequest.getAccountNumber(), "Account Not found", "404");
                    }

                    return new ResponseEntity<Response>(response,HttpStatus.OK);
                }).exceptionally(throwable -> {
                    Error failureResponse = new Error(throwable.getMessage(), "TECHERROR", "500");
                    return new ResponseEntity<>(failureResponse, HttpStatus.INTERNAL_SERVER_ERROR);
                });
    }


}