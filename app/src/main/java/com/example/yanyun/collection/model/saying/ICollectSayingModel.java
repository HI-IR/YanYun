package com.example.yanyun.collection.model.saying;

import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： 收藏的言的Model接口
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 18:10
 */
public interface ICollectSayingModel {
    //获取喜欢的言
    void getFavoriteData(CallBack callBack);
    interface CallBack{
        void  onSuccess(ArrayList<FavoriteEntity> favorites);
        void  onError();
    }
}
