package com.example.yanyun.model.bean.json;

/**
 * description ： Login的登录Json类
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 21:23
 */
public class LoginJson extends BaseJson {

    public DataBean data;
    public int errorCode;
    public String errorMsg;

    public static class DataBean {
        public int id;
        public String publicName;
        public String username;

    }


}
