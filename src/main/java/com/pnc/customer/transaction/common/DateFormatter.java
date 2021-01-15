package com.pnc.customer.transaction.common;

import io.micrometer.core.instrument.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static Date convertString(String s) {
        Date date=null;
        if(!StringUtils.isBlank(s)){
            try {
                 return new SimpleDateFormat("YYYY-MM-DD").parse(s);
            } catch (ParseException e) {

            }
        }
        return date;
    }
}
