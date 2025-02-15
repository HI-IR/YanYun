package com.example.yanyun.collection.view.poem;

import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： 收藏-诗句
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 19:44
 */
public interface ICollectionPoem {
    //显示错误信息
    void showError();

    //设置适配器
    void setAdapter(ArrayList<FavoriteEntity> favorites);
}
