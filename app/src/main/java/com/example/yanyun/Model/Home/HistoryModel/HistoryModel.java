package com.example.yanyun.Model.Home.HistoryModel;

import android.os.Handler;

import com.example.yanyun.Model.Bean.Json.HistoryJson;
import com.example.yanyun.Model.Bean.Json.ImageJson;
import com.example.yanyun.Model.Home.ImageModel.IImageModel;
import com.example.yanyun.Utils.Net;

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

        new Net().doGet("https://www.mxnzp.com/api/history/today",hashMap,handler,new HistoryJson());
    }
}
