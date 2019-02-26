package com.example.tut.csv.utils;

import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    public static final String DATETIME_WITH_TIMEZONE_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static Date currentDate() {
        return new Date();
    }

    public static String toString(String format, @NotNull Date date) {
        SimpleDateFormat fm = StringUtils.isEmpty(format) ? new SimpleDateFormat(DATETIME_WITH_TIMEZONE_ISO8601) : new SimpleDateFormat(format);
        return fm.format(date);
    }

    public static Date valueOf(String format, String val) {
        try {
            SimpleDateFormat fm = StringUtils.isEmpty(format) ? new SimpleDateFormat(DATETIME_WITH_TIMEZONE_ISO8601) : new SimpleDateFormat(format);
            return fm.parse(val);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date valueOf(String val) {
        return valueOf(null, val);
    }
}
