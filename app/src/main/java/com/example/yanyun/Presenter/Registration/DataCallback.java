package com.example.yanyun.Presenter.Registration;

import com.example.yanyun.Model.Bean.Json.LoginJson;
import com.example.yanyun.Model.Bean.Json.RegJson;

/**
 * description ： 接口回调，实现View层的动作
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 11:32
 */
public interface DataCallback {
    void onDataParsed(RegJson regJson);
}
