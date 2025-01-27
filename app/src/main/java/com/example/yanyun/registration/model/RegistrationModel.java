package com.example.yanyun.registration.model;

import android.os.Handler;

import com.example.yanyun.json.RegJson;
import com.example.yanyun.utils.Net;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

/**
 * description ： RegistrationModel
 * 注册
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 09:23
 */
public class RegistrationModel implements IRegistrationModel {
    /***
     * Post注册信息
     * @param username
     * @param password
     * @param handler
     */
    @Override
    public void doReg(String username, String password, Handler handler) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", username);
        hashMap.put("password", password);
        hashMap.put("repassword", password);
        new Net().doPost("https://www.wanandroid.com/user/register", hashMap, handler, new TypeToken<RegJson>(){}.getType());
    }
}
