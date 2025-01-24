package com.example.yanyun.model.home.sayingModel;

import android.os.Handler;

import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.model.home.poemModel.IPoemModel;

/**
 * description ： SayingView的Model层接口
 * 获取美言与作者数据，取消收藏，收藏功能
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 15:05
 */
public interface ISayingModel {
    void GetSaying(Handler handler);//获取美言与作者数据
    void Collection(String content,String author);//收藏功能
    void unCollection(String content);//取消收藏

    void isCollected(String content, Callback callback);
    //回调，收藏和未收藏
    interface Callback{
        void onCollected();
        void onUnCollected();
    }
}
