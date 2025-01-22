package com.example.yanyun.Model.Home.ImageModel;

import android.os.Handler;

import com.example.yanyun.Model.Bean.Json.ImageJson;
import com.example.yanyun.Utils.Net;

import java.util.HashMap;

/**
 * description ： Image的Model
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/22 11:08
 */
public class ImageModel implements  IImageModel{
    @Override
    public void GetPoem(Handler handler,int count) {

        //api手册上要求：https://api.no0a.cn/api/bing/day（day为0~7）
        new Net().doGet(new StringBuilder("https://api.no0a.cn/api/bing/").append(count).toString(),handler,new ImageJson());
    }
}
