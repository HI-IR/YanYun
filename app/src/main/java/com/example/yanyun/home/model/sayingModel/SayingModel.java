package com.example.yanyun.home.model.sayingModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.yanyun.database.YanYunDatabase;
import com.example.yanyun.database.dao.FavoriteDao;
import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.json.SayingJson;
import com.example.yanyun.utils.Net;
import com.example.yanyun.utils.Time;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;


/**
 * description ： Saying的Model层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 15:05
 */
public class SayingModel implements ISayingModel {
    Context mContext;

    public SayingModel(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void GetSaying(Handler handler) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("token", "b09en9retx5ycotbpbhhxhh2y7wym8");
        new Net().doGet("https://v3.alapi.cn/api/hitokoto", hashMap, handler,new TypeToken<SayingJson>(){}.getType());
    }

    //收藏
    @Override
    public void Collection(String content, String author) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取目前登录的账户
                SharedPreferences sharedPreferences = mContext.getSharedPreferences("loginedUser", Context.MODE_PRIVATE);
                long user_id = sharedPreferences.getLong("LOGINED_USER", -1);

                //收藏
                YanYunDatabase db = YanYunDatabase.getDatabase();
                FavoriteDao favoriteDao = db.getFavoriteDao();

                //判断数据库中该用户有没有收藏这个内容
                int count = favoriteDao.countByContent(content, user_id);
                if (count==0){
                    //没有收藏则收藏
                    FavoriteEntity saying = new FavoriteEntity(user_id, "Saying", content, author, Time.getTime());
                    favoriteDao.InsertData(saying);
                }
            }
        }).start();
    }

    //取消收藏
    @Override
    public void unCollection(String content) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取目前登录的账户
                SharedPreferences sharedPreferences = mContext.getSharedPreferences("loginedUser", Context.MODE_PRIVATE);
                long user_id = sharedPreferences.getLong("LOGINED_USER", -1);
                //取消收藏
                YanYunDatabase db = YanYunDatabase.getDatabase();
                FavoriteDao favoriteDao = db.getFavoriteDao();
                favoriteDao.DeleteDataByContent(content);
            }
        }).start();
    }

    @Override
    public void isCollected(String content, Callback callback) {
        //获取目前登录的账户
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("loginedUser", Context.MODE_PRIVATE);
        long user_id = sharedPreferences.getLong("LOGINED_USER", -1);
        YanYunDatabase db = YanYunDatabase.getDatabase();
        FavoriteDao favoriteDao = db.getFavoriteDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flag;
                //判断数据库中该用户有没有收藏这个内容
                int count = favoriteDao.countByContent(content, user_id);
                flag=(count==0)?false:true;//count是否为0，为0则flag为false，未收藏，不为0则flag未true，已经收藏了

                if (flag){
                    callback.onCollected();
                }else {
                    callback.onUnCollected();
                }

            }
        }).start();
    }
}
