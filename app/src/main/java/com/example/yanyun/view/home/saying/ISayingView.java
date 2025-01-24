package com.example.yanyun.view.home.saying;

import com.example.yanyun.model.bean.json.SayingJson;

/**
 * description ： SayingView的接口
 * 显示加载条，隐藏加载条，更新美言和作者数据，设置数据，显示错误信息
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 15:00
 */
public interface ISayingView {
    void showLoading();//显示加载条

    void hideLoading();//隐藏加载条

    void doUpdateInfo();//更新美言和作者

    void setInfo(SayingJson sayingJson);//设置数据

    void showError(String msg);//显示错误信息

    void setCollected();//设置已收藏

    void setUnCollected();//设置未收藏
}
