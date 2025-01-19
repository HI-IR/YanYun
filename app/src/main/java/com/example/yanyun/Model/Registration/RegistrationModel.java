package com.example.yanyun.Model.Registration;

import com.example.yanyun.Model.Bean.Json.RegJson;
import com.example.yanyun.Presenter.Registration.DataCallback;
import com.example.yanyun.Presenter.Registration.RegPresenter;
import com.example.yanyun.Utils.Net;

import java.util.HashMap;
import android.os.Handler;

/**
 * description ： RegistrationModel
 * 注册
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 09:23
 */
public class RegistrationModel implements IRegistrationModel{
    /***
     * Post注册信息
     * @param username
     * @param password
     * @param handler
     */
    @Override
    public void doReg(String username, String password, Handler handler) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("username",username);
        hashMap.put("password",password);
        hashMap.put("repassword",password);
        Net.doPost("https://www.wanandroid.com/user/register",hashMap,handler);
    }

    @Override
    public void parseJson(String json, DataCallback dataCallback) {
        RegJson regJson = new RegJson().decodeJson(json);
        dataCallback.onDataParsed(regJson);
    }


}
