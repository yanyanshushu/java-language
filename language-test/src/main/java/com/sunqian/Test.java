package com.sunqian;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Test {

    /**
     * test whatever you like.
     * @param args
     */
    public static void main(String[] args) throws MalformedURLException {
//        int i=0;
//        while (true){
//            i++;
//            System.out.println(i);
//        }


////        i=1代表幼儿园小班，15，代表高中三年级
//        for(int i=1;i<=15;i++){
//            CaculateYear(i);
//        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate now=LocalDate.parse("2020-06-15",df);
        LocalDateTime nowDatetime=LocalDateTime.parse("2020-06-15 00:00:00",df1);
        System.out.println(nowDatetime);
        URL u =new URL("http://www.lkjjlkjlkjljljlkjasdflajdfjlajdfljdsfloiulakjdfasdjf123.com");
    }

    private static String CaculateYear(int grade) {
        String result="";
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int month = instance.get(Calendar.MONTH); // 月份
        int year = instance.get(Calendar.YEAR);   // 年

        boolean monthAfter8=month>=8;

        if(grade<4){
            result= "幼儿园,"+grade+"年级,(";
            if(monthAfter8){
                result=result+(year-grade+1)+"-"+(year-grade+3)+")";
            }else{
                result=result+(year-grade)+"-"+(year-grade+2)+")";
            }
        }else if(grade<10){
            result= "小学,"+(grade-3)+"年级,(";
            if(monthAfter8){
                result=result+(year-(grade-3)+1)+"-"+(year-(grade-3)+6)+")";
            }else{
                result=result+(year-(grade-3))+"-"+(year-(grade-3)+6)+")";
            }
        }else if(grade<13){
            result= "初中,"+(grade-3)+"年级,(";
            if(monthAfter8){
                result=result+(year-(grade-9)+1)+"-"+(year-(grade-9)+3)+")";
            }else{
                result=result+(year-(grade-9))+"-"+(year-(grade-90)+3)+")";
            }
        }else if(grade<16){
            result= "高中,"+(grade-12)+"年级,(";
            if(monthAfter8){
                result=result+(year-(grade-12)+1)+"-"+(year-(grade-12)+3)+")";
            }else{
                result=result+(year-(grade-12))+"-"+(year-(grade-12)+3)+")";
            }
        }
        System.out.println(result);
        return result;
    }
}
