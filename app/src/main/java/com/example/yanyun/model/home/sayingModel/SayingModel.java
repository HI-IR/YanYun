package com.example.yanyun.model.home.sayingModel;

import android.os.Handler;

import com.example.yanyun.model.bean.json.SayingJson;
import com.example.yanyun.utils.Net;

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
