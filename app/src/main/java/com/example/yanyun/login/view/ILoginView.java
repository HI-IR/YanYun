package com.example.yanyun.login.view;

import android.content.Context;

/**
 * description ： Login页面的功能
 * 显示加载条，隐藏加载条，跳转home，显示错误信息,填入密码，监听是否需要记住密码，获取当前Activity的Context，勾选记住密码
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 17:48
 */
public interface ILoginView {
    void showLoading();//显示加载条

    void hideLoading();//隐藏加载条

    void ToHome();//跳转到主页

    void showError(String msg);//显示错误信息

    void EnterInf(String username, String password);//将账号密码填入登录页

    boolean shouldRemember();//是否需要记住密码

    Context myGetContext();

    void check(boolean shouldRemember);//勾选记住密码
}
