package com.example.yanyun.View.Home.Image;

import android.media.Image;

import com.example.yanyun.Model.Bean.Json.ImageJson;
import com.example.yanyun.Model.Bean.Json.SayingJson;

/**
 * description ： ImageView的接口
 *  显示加载条，隐藏加载条，更新美言和作者数据，设置数据，显示错误信息
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/22 00:07
 */
public interface IImageView {
    void showLoading();//显示加载条

    void hideLoading();//隐藏加载条

    void doUpdateInfo(int count);//更新美言和作者

    void setInfo(ImageJson imageJson);//设置数据

    void showError(String msg);//显示错误信息
}
