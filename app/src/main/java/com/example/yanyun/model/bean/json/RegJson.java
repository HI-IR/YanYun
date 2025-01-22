package com.example.yanyun.model.bean.json;

/**
 * description ： 注册的Json类
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 11:33
 */
public class RegJson extends BaseJson {


    public DataBean data;
    public int errorCode;
    public String errorMsg;


    public static class DataBean {
        /**
         * admin : false
         * chapterTops : []
         * coinCount : 0
         * collectIds : []
         * email :
         * icon :
         * id : 166102
         * nickname : lm1sbt_i2z43
         * password :
         * publicName : lm1sbt_i2z43
         * token :
         * type : 0
         * username : lm1sbt_i2z43
         */

        public int id;
        public String publicName;
        public String username;
    }
}
