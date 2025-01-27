package com.example.yanyun.home.view.poem;

import com.example.yanyun.json.PoemJson;

/**
 * description ： SayingView的接口
 * 显示加载条，隐藏加载条，更新诗词和作者数据，设置数据，显示错误信息
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 17:57
 */
public interface IPoemView {
    void showLoading();//显示加载条

    void hideLoading();//隐藏加载条

    void doUpdateInfo();//更新美言和作者

    void setInfo(PoemJson poemJson);//设置数据

    void showError(String msg);//显示错误信息

    void setCollected();//设置已收藏

    void setUnCollected();//设置未收藏
}
