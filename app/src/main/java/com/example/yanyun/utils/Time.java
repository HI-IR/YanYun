package com.example.yanyun.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * description ： 时间的工具类，用于获取点击时间
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/24 13:11
 */
public class Time {
    public static String getTime(){
        // 获取当前时间
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        // 定义日期时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String formattedDateTime = sdf.format(currentDate);
        return formattedDateTime;
    }

}
