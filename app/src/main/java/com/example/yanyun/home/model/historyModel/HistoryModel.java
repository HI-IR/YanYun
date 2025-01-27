package com.example.yanyun.home.model.historyModel;

import android.os.Handler;


import com.example.yanyun.json.HistoryApiWapper;
import com.example.yanyun.json.HistoryJson;
import com.example.yanyun.utils.Net;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

/**
 * description ： History的Model层
 * 获取数据，解析json
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/22 11:08
 */
public class HistoryModel implements IHistoryModel {
    @Override
    public void GetHistory(Handler handler) {
        HashMap<String,String>hashMap = new HashMap<>();
        hashMap.put("type","1");
        hashMap.put("app_id","trtokklftikdpwje");
        hashMap.put("app_secret","aeTiSGickk10FdCupA9xIxKrG5Axs6zA");

        new Net().doGet("https://www.mxnzp.com/api/history/today",hashMap,handler,new TypeToken<HistoryApiWapper<HistoryJson>>(){}.getType());
    }
}
