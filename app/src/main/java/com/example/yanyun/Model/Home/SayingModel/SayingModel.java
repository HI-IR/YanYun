package com.example.yanyun.Model.Home.SayingModel;

import android.os.Handler;

import com.example.yanyun.Model.Bean.Json.SayingJson;
import com.example.yanyun.Utils.Net;

import java.util.HashMap;


/**
 * description ： Saying的Model层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 15:05
 */
public class SayingModel implements ISayingModel {
    @Override
    public void GetSaying(Handler handler) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("token", "b09en9retx5ycotbpbhhxhh2y7wym8");
        new Net().doGet("https://v3.alapi.cn/api/hitokoto", hashMap, handler, new SayingJson());
    }
}
