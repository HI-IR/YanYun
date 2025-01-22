package com.example.yanyun.Model.Bean.Json;

import java.util.List;

/**
 * description ： History的Json类
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/22 11:40
 */
public class HistoryJson extends BaseJson{

    /**
     * code : 1
     * msg : 数据返回成功！
     * data :
     * */

    public int code;
    public String msg;
    public List<DataBean> data;


    public static class DataBean {
        /**
         * picUrl : http://www.todayonhistory.com/uploadfile/2017/0206/20170206100942331.jpg
         * title : “吃豆人之父”、　日本游戏产业元老级中村雅哉去世
         * year : 2017
         * month : 1
         * day : 22
         * details :
         **/

        public String title;
        public String year;
        public int month;
        public int day;
        public String details;


    }
}
