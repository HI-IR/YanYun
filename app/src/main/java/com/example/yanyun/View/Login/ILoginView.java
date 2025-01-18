package com.example.yanyun.View.Login;

/**
 * description ： Login页面的功能
 * 显示加载条，隐藏加载条，跳转home，跳转Registration
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 17:48
 */
public interface ILoginView {
    void showLoging();//显示加载条
    void hideLoading();//隐藏加载条
    void doHome();
    void doRegistration();
    void showError();
}
