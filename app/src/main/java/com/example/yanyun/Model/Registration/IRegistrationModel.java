package com.example.yanyun.Model.Registration;

import android.os.Handler;

import com.example.yanyun.Presenter.Registration.DataCallback;

/**
 * description ：  RegistrationModel的接口
 * 注册,解析数据,
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 09:23
 */
public interface IRegistrationModel {
    void doReg(String username, String password, Handler handler);//向服务端注册
    void parseJson(String json, DataCallback dataCallback);

}
