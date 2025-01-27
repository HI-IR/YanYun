package com.example.yanyun.json;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

/**
 * description ： 通过泛型和 Gson 来解析 JSON 数据并将其映射到对象中，同时将Json数据的外层和data层分开
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/27 17:53
 */
public class ImageApiWapper<T> {
    private static final Gson GSON = new Gson();
    /**
     * status : 1
     * bing : {"url":"http://s.cn.bing.net/th?id=OHR.PlumParakeet_ZH-CN0311942558_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp","copyright":"希莫加的紫红头鹦鹉，卡纳塔克邦，印度 (© Hira Punjabi/Alamy Stock Photo)"}
     */
    @SerializedName("status")
    public int status;

    @SerializedName("bing")
    public T bing;

    public ImageApiWapper<T> dedecodeJson(String json, TypeToken<HistoryApiWapper<T>> typeToken){
        return GSON.fromJson(json,typeToken.getType());
    }
}
