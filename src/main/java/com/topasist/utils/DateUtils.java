package com.topasist.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
public class DateUtils {

    private static final String INPUT_DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss'Z'";

    public static String convertDateToLocaleFormat(String stringDate, Locale locale) {
        try {
            DateFormat df = new SimpleDateFormat(INPUT_DATE_FORMAT);
            Date date = df.parse(stringDate);
            return DateFormat.getDateInstance(DateFormat.DEFAULT, locale).format(date);
        } catch (ParseException e) {
            log.warn("ParseException " + e.getMessage());
        }
        return stringDate;
    }
}
