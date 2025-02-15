package com.example.yanyun.json;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * description ： 通过泛型和 Gson 来解析 JSON 数据并将其映射到对象中，同时将Json数据的外层和data层分开
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/27 14:21
 */
public class HistoryApiWapper<T> {
    private static final Gson GSON = new Gson();
    @SerializedName("code")
    public int code;

    @SerializedName("msg")
    public String msg;

    @SerializedName("data")
    public List<T> data;


    /***
     * 解析json
     * @param json
     * @return
     */
    public HistoryApiWapper<T> decodeJson(String json, TypeToken<HistoryApiWapper<T>> typeToken) {
        return GSON.fromJson(json, typeToken.getType());
    }
}
