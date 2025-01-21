package com.example.yanyun.Model.Home.SayingModel;

/**
 * description ： SayingView的Model层接口
 * 获取美言与作者String数据、解析Json
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 15:05
 */
public interface ISayingModel {
    void GetSaying(GetCallback getCallback);

    interface GetCallback {
        void onSuccess();

        void onError();
    }
}
