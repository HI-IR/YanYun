package com.example.yanyun.home.model.imageModel;

import android.os.Handler;

/**
 * description ： Poem的Model层接口
 * 获取美图数据，取消收藏，收藏功能
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/22 11:08
 */
public interface IImageModel {
    void getPoem(Handler handler, int count);//获取图片数据

    void collection(String content, String author);//收藏功能

    void unCollection(String content);//取消收藏

    void isCollected(String content, callback callback);

    //回调，收藏和未收藏
    interface callback {
        void onCollected();

        void onUnCollected();
    }


}
