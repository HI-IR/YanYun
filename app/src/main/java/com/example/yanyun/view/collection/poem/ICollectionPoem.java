package com.example.yanyun.view.collection.poem;

import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： TODO:类的作用
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 19:44
 */
public interface ICollectionPoem {
    void showError();
    void setAdapter(ArrayList<FavoriteEntity> favorites);
}
