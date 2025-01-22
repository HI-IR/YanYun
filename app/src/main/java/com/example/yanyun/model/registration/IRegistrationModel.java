package com.example.yanyun.model.registration;

import android.os.Handler;

/**
 * description ：  RegistrationModel的接口
 * 注册,解析数据,
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 09:23
 */
public interface IRegistrationModel {
    void doReg(String username, String password, Handler handler);//向服务端注册

}
