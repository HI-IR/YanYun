package com.example.yanyun.model.home.poemModel;

import android.os.Handler;

import com.example.yanyun.model.bean.json.PoemJson;
import com.example.yanyun.utils.Net;

import java.util.HashMap;


/**
 * description ：  Poem的Model层
 * Get诗词数据
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 18:01
 */
public class PoemModel implements IPoemModel{

    //获取诗词数据
    @Override
    public void GetPoem(Handler handler) {
        //带响应头的get（欸API手册里面要求的）
        HashMap<String,String> RequestProperty = new HashMap<>();
        RequestProperty.put("Cookie","X-User-Token=ziEwnXaMfPSEKd0P3iBRwwaqEHatdz6V");
        new Net().doGet("https://v2.jinrishici.com/sentence",handler, new PoemJson(),RequestProperty);
    }
}
