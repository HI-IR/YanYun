package com.example.yanyun.login.model;

import android.content.Context;
import android.os.Handler;

import com.example.yanyun.json.LoginJson;
import com.example.yanyun.login.presenter.DataCallback;

/**
 * description ： 该接口用于验证登录，记住密码，获取登录信息，在数据库中记录数据
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 20:13
 */
public interface ILoginModel {
    void login(String username, String password, Handler handler);

    void rememberPassword(String username, String password, Boolean shouldRemember, Context context);//记住密码

    void getLogin(DataCallback dataCallback, Context context);//获取登录信息

    void insertUser(LoginJson loginJson);

    void saveLoginedUser(long user_id);//保存是谁登录了
}
