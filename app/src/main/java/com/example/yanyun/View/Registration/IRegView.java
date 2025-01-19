package com.example.yanyun.View.Registration;

/**
 * description ： Login页面的功能
 * 跳转登录页,显示加载条，隐藏加载条，显示错误信息
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 09:18
 */
public interface IRegView {
    void ToLogin();//跳转登录页

    void showLoging();//显示加载条

    void hideLoading();//隐藏加载条

    void showError(String msg);//显示错误信息
}
