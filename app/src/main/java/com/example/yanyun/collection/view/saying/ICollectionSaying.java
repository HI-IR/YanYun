package com.example.yanyun.collection.view.saying;

import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： 收藏-美言页面
 * 显示错误，设置适配器
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 18:54
 */
public interface ICollectionSaying {
    //显示错误信息
    void showError();

    //设置适配器
    void setAdapter(ArrayList<FavoriteEntity> favorites);
}
