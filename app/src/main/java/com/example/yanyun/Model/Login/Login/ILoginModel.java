package com.example.yanyun.Model.Login.Login;

import android.os.Handler;

/**
 * description ： 该接口用于验证登录
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 20:13
 */
public interface ILoginModel {
    void login(String username, String password, Handler handler);
    interface Callback{
        void onSuccess(String Username);
        void onError(String error);
    }
}
