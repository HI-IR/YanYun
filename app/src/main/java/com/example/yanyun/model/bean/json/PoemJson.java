package com.example.yanyun.model.bean.json;
import java.util.List;

/**
 * description ： Poem的登录Json类
 * 用来解析名言的JSON数据
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 18:06
 */
public class PoemJson extends BaseJson {

    /**
     * status : success
     * data : {"id":"5b8b9572e116fb3714e6fddb","content":"不知近水花先发，疑是经冬雪未销。","popularity":299000,"origin":{"title":"早梅","dynasty":"唐代","author":"张谓","content":["一树寒梅白玉条，迥临村路傍溪桥。","不知近水花先发，疑是经冬雪未销。"],"translate":null},"matchTags":["冬"],"recommendedReason":"","cacheAt":"2025-01-21T18:07:21.663258981"}
     * token : ziEwnXaMfPSEKd0P3iBRwwaqEHatdz6V
     * ipAddress : 39.144.218.93
     * warning : null
     */

    public String status;
    public DataBean data;

    public static class DataBean {
        /**
         * id : 5b8b9572e116fb3714e6fddb
         * content : 不知近水花先发，疑是经冬雪未销。
         * popularity : 299000
         * origin : {"title":"早梅","dynasty":"唐代","author":"张谓","content":["一树寒梅白玉条，迥临村路傍溪桥。","不知近水花先发，疑是经冬雪未销。"],"translate":null}
         * matchTags : ["冬"]
         * recommendedReason :
         * cacheAt : 2025-01-21T18:07:21.663258981
         */

        public String content;
        public int popularity;
        public OriginBean origin;
        public String cacheAt;
        public List<String> matchTags;


        public static class OriginBean {
            /**
             * title : 早梅
             * dynasty : 唐代
             * author : 张谓
             * content : ["一树寒梅白玉条，迥临村路傍溪桥。","不知近水花先发，疑是经冬雪未销。"]
             * translate : null
             */
            public String title;
            public String dynasty;
            public String author;
            public List<String> content;
        }
    }
}
