package com.example.yanyun.Presenter.Login;

import com.example.yanyun.Model.Bean.Json.LoginJson;

/**
 * description ：接口回调，实现View层的动作
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 10:01
 */
public interface DataCallback {
    void onDataParsed(LoginJson loginJson);
}
