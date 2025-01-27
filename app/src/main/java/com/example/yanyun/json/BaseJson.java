package com.example.yanyun.json;

import com.google.gson.Gson;

/**
 * description ： Json的基础类
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 10:53
 */
public class BaseJson {
    private static final Gson GSON = new Gson();



    /***
     * 解析json
     * @param json
     * @return
     */
    public <T extends BaseJson> T decodeJson(String json) {
        Class<HistoryJson> historyJsonClass = HistoryJson.class;

        return (T) GSON.fromJson(json,historyJsonClass);
    }
}
