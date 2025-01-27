package com.example.yanyun.home.model.imageModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.yanyun.database.YanYunDatabase;
import com.example.yanyun.database.dao.FavoriteDao;
import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.json.ImageApiWapper;
import com.example.yanyun.json.ImageJson;
import com.example.yanyun.utils.Net;
import com.example.yanyun.utils.Time;
import com.google.gson.reflect.TypeToken;

/**
 * description ： Image的Model
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/22 11:08
 */
public class ImageModel implements  IImageModel{
    Context mContext;

    public ImageModel(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getPoem(Handler handler,int count) {

        //api手册上要求：https://api.no0a.cn/api/bing/day（day为0~7）
        new Net().doGet(new StringBuilder("https://api.no0a.cn/api/bing/").append(count).toString(),handler,new TypeToken<ImageApiWapper<ImageJson>>(){}.getType());
    }

    //收藏
    @Override
    public void collection(String content, String author) {
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
                    FavoriteEntity saying = new FavoriteEntity(user_id, "Image", content, author, Time.getTime());
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
    public void isCollected(String content, callback callback) {
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
