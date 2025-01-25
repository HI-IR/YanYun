package com.example.yanyun.model.user;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * description ： TODO:类的作用
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 23:09
 */
public interface IUserModel {
    void getUserInfo(CallBack callBack);//获取用户收藏数据
    interface CallBack{
        //顺序：美言，诗歌，图片，用户名
        void onSuccess(HashMap<String,String> counts);
    }


}
