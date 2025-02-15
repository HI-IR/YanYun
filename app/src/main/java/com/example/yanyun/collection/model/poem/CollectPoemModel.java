package com.example.yanyun.collection.model.poem;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.yanyun.MyApplication;
import com.example.yanyun.database.YanYunDatabase;
import com.example.yanyun.database.dao.FavoriteDao;
import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.utils.Time;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * description ： 收藏的诗的Model
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 19:30
 */
public class CollectPoemModel implements ICollectPoemModel {

    @Override
    public void getFavoriteData(CallBack callBack) {
        WeakReference<CallBack> callBackWeakReference = new WeakReference<>(callBack);
        //获取目前是谁登录了
        SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences("loginedUser", Context.MODE_PRIVATE);
        long user_id = sharedPreferences.getLong("LOGINED_USER", -1);
        YanYunDatabase database = YanYunDatabase.getDatabase();
        FavoriteDao favoriteDao = database.getFavoriteDao();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<FavoriteEntity> favoritesTemp = favoriteDao.FindFavoritePoemByid(user_id);
                ArrayList<FavoriteEntity> favorites = new ArrayList<>(favoritesTemp);
                if (favorites.size() >= 0) {
                    callBackWeakReference.get().onSuccess(favorites);
                } else {
                    callBackWeakReference.get().onError();
                }
            }
        }).start();
    }

    //收藏功能
    @Override
    public void Collect(String content, String author) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取目前登录的账户
                SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences("loginedUser", Context.MODE_PRIVATE);
                long user_id = sharedPreferences.getLong("LOGINED_USER", -1);

                //收藏
                YanYunDatabase db = YanYunDatabase.getDatabase();
                FavoriteDao favoriteDao = db.getFavoriteDao();
                //判断数据库中该用户有没有收藏这个内容
                int count = favoriteDao.countByContent(content, user_id);
                if (count == 0) {
                    //没有收藏则收藏
                    FavoriteEntity saying = new FavoriteEntity(user_id, "Poem", content, author, Time.getTime());
                    favoriteDao.InsertData(saying);
                }
            }
        }).start();
    }

    //取消收藏
    @Override
    public void unCollect(String content) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取目前登录的账户
                SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences("loginedUser", Context.MODE_PRIVATE);
                long user_id = sharedPreferences.getLong("LOGINED_USER", -1);
                //取消收藏
                YanYunDatabase db = YanYunDatabase.getDatabase();
                FavoriteDao favoriteDao = db.getFavoriteDao();
                favoriteDao.DeleteDataByContent(content, user_id);
            }
        }).start();
    }
}
