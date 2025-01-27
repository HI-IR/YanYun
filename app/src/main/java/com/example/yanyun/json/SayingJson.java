package com.example.yanyun.json;

/**
 * description ： 用来解析名言的JSON数据
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 13:10
 */
public class SayingJson extends BaseJson {

    /**
     * request_id : 740211244664078336
     * success : true
     * message : success
     * code : 200
     * data : {"id":2895,"hitokoto":"恨人神之道殊兮，怨盛年之莫当。","type":"i","from":"洛神赋","creator":"海心月"}
     * time : 1737440113
     * usage : 0
     */

    public boolean success;
    public String message;
    public DataBean data;

    public static class DataBean {
        /**
         * id : 2895
         * hitokoto : 恨人神之道殊兮，怨盛年之莫当。
         * type : i
         * from : 洛神赋
         * creator : 海心月
         */

        public String hitokoto;
        public String from;

    }
}
