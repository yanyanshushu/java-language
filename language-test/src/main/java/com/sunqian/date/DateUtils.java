package com.sunqian.date;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static void main(String[] args) {
        int year=getCurrentYear(new Date());
        System.out.println(year);
    }
    public static int getCurrentYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }
}
