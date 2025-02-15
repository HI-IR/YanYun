package com.example.yanyun.home.model.imageModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Base64;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.yanyun.database.YanYunDatabase;
import com.example.yanyun.database.dao.FavoriteDao;
import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.json.ImageApiWapper;
import com.example.yanyun.json.ImageJson;
import com.example.yanyun.utils.Net;
import com.example.yanyun.utils.Time;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;

/**
 * description ： Image的Model
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/22 11:08
 */
public class ImageModel implements IImageModel {
    Context mContext;

    public ImageModel(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getPoem(Handler handler, int count) {

        //api手册上要求：https://api.no0a.cn/api/bing/day（day为0~7）
        new Net().doGet("https://api.no0a.cn/api/bing/" + count, handler, new TypeToken<ImageApiWapper<ImageJson>>() {
        }.getType());
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
                //如果作者和版权信息相同则说明已经收藏过了该内容
                int count = favoriteDao.countImageByAuthor(user_id, author);
                if (count == 0) {
                    //没有收藏则收藏;
                    downloadSaveImg(user_id, content, author);
                }
            }
        }).start();
    }

    //取消收藏
    @Override
    public void unCollection(String author) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取目前登录的账户
                SharedPreferences sharedPreferences = mContext.getSharedPreferences("loginedUser", Context.MODE_PRIVATE);
                long user_id = sharedPreferences.getLong("LOGINED_USER", -1);
                //取消收藏

                YanYunDatabase db = YanYunDatabase.getDatabase();
                FavoriteDao favoriteDao = db.getFavoriteDao();
                favoriteDao.DeleteDataByAuthor(author, user_id);
            }
        }).start();
    }

    @Override
    public void isCollected(String author, callback callback) {
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
                int count = favoriteDao.countImageByAuthor(user_id, author);
                flag = count != 0;//count是否为0，为0则flag为false，未收藏，不为0则flag未true，已经收藏了

                if (flag) {
                    callback.onCollected();
                } else {
                    callback.onUnCollected();
                }

            }
        }).start();
    }

    //下载图片,并收藏
    public void downloadSaveImg(long user_id, String url, String author) {
        Glide.with(mContext).asBitmap().load(url).into(new CustomTarget<Bitmap>() {
            @Override
            //当资源准备好时
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                resource.compress(Bitmap.CompressFormat.JPEG, 80, stream);
                //保存原图质量的80

                // 获取压缩后的字节数组
                byte[] byteArray = stream.toByteArray();

                //将字节数组转化为字符串（采用Base64编码）
                String result = Base64.encodeToString(byteArray, Base64.DEFAULT);

                //存入数据库
                FavoriteEntity image = new FavoriteEntity(user_id, "Image", result, author, Time.getTime());
                YanYunDatabase database = YanYunDatabase.getDatabase();
                FavoriteDao favoriteDao = database.getFavoriteDao();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        favoriteDao.InsertData(image);
                    }
                }).start();
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }
        });
    }


}
