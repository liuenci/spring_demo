package com.spring.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getNowTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) {
        System.out.println(getNowTime());
    }
}
