package com.example.yanyun.view.collection.saying;

import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * description ： TODO 111
 * 显示错误，设置适配器
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 18:54
 */
public interface ICollectionSaying {
    void showError();
    void setAdapter(ArrayList<FavoriteEntity> favorites);
}
