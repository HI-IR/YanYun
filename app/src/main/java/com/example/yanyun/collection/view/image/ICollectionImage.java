package com.example.yanyun.collection.view.image;

import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： 收藏-美图
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 20:04
 */
public interface ICollectionImage {
    void showError();

    void setAdapter(ArrayList<FavoriteEntity> favorites);
}
