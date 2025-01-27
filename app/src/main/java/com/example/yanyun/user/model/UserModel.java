package com.example.yanyun.user.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.yanyun.MyApplication;
import com.example.yanyun.database.YanYunDatabase;
import com.example.yanyun.database.dao.FavoriteDao;
import com.example.yanyun.database.dao.UsersDao;

import java.util.HashMap;

/**
 * description ： TODO:类的作用
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 23:09
 */
public class UserModel implements IUserModel {
    YanYunDatabase database;
    FavoriteDao favoriteDao;
    UsersDao usersDao;

    public UserModel() {
        database = YanYunDatabase.getDatabase();
        favoriteDao = database.getFavoriteDao();
        usersDao = database.getUsersDao();
    }

    @Override
    public void getUserInfo(CallBack callBack) {
        SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences("loginedUser", Context.MODE_PRIVATE);
        long user_id = sharedPreferences.getLong("LOGINED_USER", -1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //顺序为：美言，诗歌，图片
                HashMap<String,String> counts = new HashMap<>();
                counts.put("SayingCount",String.valueOf(favoriteDao.countSayingByid(user_id)));
                counts.put("PoemCount",String.valueOf(favoriteDao.countPoemByid(user_id)));
                counts.put("ImageCount",String.valueOf(favoriteDao.countImageByid(user_id)));

                String userName = usersDao.getUserName(user_id);
                counts.put("UserName",userName);
                callBack.onSuccess(counts);
            }
        }).start();
    }




}
