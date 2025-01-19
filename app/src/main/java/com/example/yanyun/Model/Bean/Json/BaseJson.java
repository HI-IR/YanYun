package com.example.yanyun.Model.Bean.Json;

import com.google.gson.Gson;

/**
 * description ： Json的基础类
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 10:53
 */
public class BaseJson {
    private final Gson gson;
    public BaseJson(){
        gson=new Gson();
    }

    /***
     * 解析json
     * @param json
     * @return
     */
    public <T extends BaseJson> T decodeJson(String json){
        return (T) gson.fromJson(json, this.getClass());
    }
}
