package com.example.yanyun.model.home.poemModel;

import android.os.Handler;

import com.example.yanyun.model.home.imageModel.IImageModel;

/**
 * description ： Poem的Model层接口
 *  * 获取古诗与作者数据，取消收藏，收藏功能
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 18:01
 */
public interface IPoemModel {
    void GetPoem(Handler handler);//获取古诗与作者数据
    void Collection(String content,String author);//收藏功能
    void unCollection(String content);//取消收藏


    void isCollected(String content, Callback callback);
    //回调，收藏和未收藏
    interface Callback{
        void onCollected();
        void onUnCollected();
    }
}
