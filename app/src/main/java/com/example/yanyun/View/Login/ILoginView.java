package com.example.yanyun.View.Login;

/**
 * description ： Login页面的功能
 * 显示加载条，隐藏加载条，跳转home，，填入密码
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 17:48
 */
public interface ILoginView {
    void showLoging();//显示加载条

    void hideLoading();//隐藏加载条

    void ToHome();//跳转到主页


    void showError(String msg);

    void EnterInf(String username,String password);//将账号密码填入登录页
}
