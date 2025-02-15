package com.example.yanyun.collection.model.image;

import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： 收藏的图的Model接口
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 19:54
 */
public interface ICollectImageModel {
    //获取喜欢的图
    void getFavoriteData(CallBack callBack);

    void collect(String content, String author);//收藏功能

    void unCollect(String content);//取消收藏

    interface CallBack {
        void onSuccess(ArrayList<FavoriteEntity> favorites);

        void onError();
    }
}
