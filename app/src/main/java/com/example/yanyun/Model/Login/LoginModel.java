package com.example.yanyun.Model.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.yanyun.Model.Bean.Json.LoginJson;
import com.example.yanyun.Presenter.Login.DataCallback;
import com.example.yanyun.Utils.Net;

import java.util.HashMap;

/**
 * description ： 实现登录，实现登录Json的解析，实现记住密码
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 21:16
 */
public class LoginModel implements ILoginModel {

    @Override
    public void login(String username, String password, Handler handler) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", username);
        hashMap.put("password", password);
        new Net().doPost("https://www.wanandroid.com/user/login", hashMap, handler, new LoginJson());
    }


    @Override
    public void rememberPassword(String username, String password, Boolean shouldRemember, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("KEY_REMEMBER_PASSWORD", shouldRemember);
        //保存密码和用户名，同时保存是否记住密码
        if (shouldRemember) {
            edit.putString("KEY_USERNAME", username);
            edit.putString("KEY_PASSWORD", password);
        } else {
            edit.putString("KEY_USERNAME", username);
            edit.putString("KEY_PASSWORD", "");
        }
        edit.apply();
    }

    @Override
    public void getLogin(DataCallback dataCallback, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        HashMap hashMap = new HashMap<>();
        hashMap.put("KEY_REMEMBER_PASSWORD", sharedPreferences.getBoolean("KEY_REMEMBER_PASSWORD", false));
        hashMap.put("KEY_USERNAME", sharedPreferences.getString("KEY_USERNAME", ""));
        hashMap.put("KEY_PASSWORD", sharedPreferences.getString("KEY_PASSWORD", ""));
        dataCallback.onLoginData(hashMap);
    }
}
