package com.dyj.dim.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/13.
 */

public class DateUtils {

    private SimpleDateFormat simpleDateFormat;

    public DateUtils() {
        simpleDateFormat = new SimpleDateFormat();
    }

    public String formatDate(long time, String format) {
//        simpleDateFormat.format(new Date(time));
        return new Date(time).toString();
    }

}
