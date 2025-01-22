package com.example.yanyun.presenter.login;

import java.util.HashMap;

/**
 * description ：接口回调，实现View层的动作
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 10:01
 */
public interface DataCallback {
    void onLoginData(HashMap<String, String> hashMap);//回调登录数据
}
