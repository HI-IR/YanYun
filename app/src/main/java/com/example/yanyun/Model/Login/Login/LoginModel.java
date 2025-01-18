package com.example.yanyun.Model.Login.Login;

import android.os.Handler;

import com.example.yanyun.Utils.Net;

import java.util.HashMap;

/**
 * description ： 实现登录
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 21:16
 */
public class LoginModel implements ILoginModel{

    @Override
    public void login(String username, String password,Handler handler) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("username",username);
        hashMap.put("password",password);
        Net.doPost("https://www.wanandroid.com/user/login",hashMap,handler);
    }

}
