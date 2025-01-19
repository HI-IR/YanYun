package com.example.yanyun.Model.Login;

import android.os.Handler;

import com.example.yanyun.Presenter.Login.DataCallback;

/**
 * description ： 该接口用于验证登录，登录Json解析
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 20:13
 */
public interface ILoginModel {
    void login(String username, String password, Handler handler);
    void parseJson(String json, DataCallback dataCallback);

}
