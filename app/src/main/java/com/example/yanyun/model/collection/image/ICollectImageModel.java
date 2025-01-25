package com.example.yanyun.model.collection.image;

import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.model.collection.poem.ICollectPoemModel;

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
    interface CallBack{
        void  onSuccess(ArrayList<FavoriteEntity> favorites);
        void  onError();
    }
}
