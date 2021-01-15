package com.pnc.customer.transaction.common;

import com.pnc.customer.transaction.TransactionApplication;
import org.springframework.boot.SpringApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) throws ParseException {
        String date= "2019-01-24";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=formatter.parse(date);
        System.out.println("@@@@"+date1);
        System.out.println("######"+formatter.format(date1));


        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "7-12-2013";

        try {

            Date date2 = formatter1.parse(dateInString);
            System.out.println(date2);
            System.out.println(formatter1.format(date2));

        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

}
