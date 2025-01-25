package com.example.yanyun.model.collection.poem;

import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.model.collection.saying.ICollectSayingModel;

import java.util.ArrayList;

/**
 * description ： 收藏的诗的Model接口
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 19:30
 */
public interface ICollectPoemModel {
    //获取喜欢的诗
    void getFavoriteData(CallBack callBack);
    interface CallBack{
        void  onSuccess(ArrayList<FavoriteEntity> favorites);
        void  onError();
    }
}
