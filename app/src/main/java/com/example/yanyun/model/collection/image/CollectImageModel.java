package com.example.yanyun.model.collection.image;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.yanyun.database.MyApplication;
import com.example.yanyun.database.YanYunDatabase;
import com.example.yanyun.database.dao.FavoriteDao;
import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.model.collection.poem.ICollectPoemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * description ： 收藏的图的Model
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 19:54
 */
public class CollectImageModel implements ICollectImageModel{
    @Override
    public void getFavoriteData(CallBack callBack) {
        //获取目前是谁登录了
        SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences("loginedUser", Context.MODE_PRIVATE);
        long user_id = sharedPreferences.getLong("LOGINED_USER", -1);
        YanYunDatabase database = YanYunDatabase.getDatabase();
        FavoriteDao favoriteDao = database.getFavoriteDao();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<FavoriteEntity> favoritesTemp = favoriteDao.FindFavoriteImageByid(user_id);
                ArrayList<FavoriteEntity> favorites=new ArrayList<>(favoritesTemp);
                if (favorites.size()>=0){
                    callBack.onSuccess(favorites);
                }else{
                    callBack.onError();
                }
            }
        }).start();
    }
}
