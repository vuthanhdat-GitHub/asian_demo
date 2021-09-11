package com.asian.backend.utils.DateTimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

    public static String getDateTimeNow(String format) {
        if (format == null) {
            format = "dd/MM/yyyy HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date now = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(now);
    }

    public static String formatDate(Date date, String format) {
        if (format == null) {
            format = "dd/MM/yyyy HH:mm:ss";
        }
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);

    }
}



