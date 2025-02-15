package com.example.yanyun;

import android.app.Application;
import android.content.Context;

/**
 * description ： 用来获取应用级别的上下文
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/24 12:15
 */
public class MyApplication extends Application {
    private static Application context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
