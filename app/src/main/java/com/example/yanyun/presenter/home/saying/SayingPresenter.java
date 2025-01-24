package com.example.yanyun.presenter.home.saying;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.model.bean.json.SayingJson;
import com.example.yanyun.model.home.imageModel.IImageModel;
import com.example.yanyun.model.home.sayingModel.ISayingModel;
import com.example.yanyun.model.home.sayingModel.SayingModel;
import com.example.yanyun.view.home.saying.ISayingView;

/**
 * description ： Saying的Presenter层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 16:21
 */
public class SayingPresenter {
    ISayingView iSayingView;
    ISayingModel iSayingModel;
    Handler handler;

    public SayingPresenter(ISayingView iSayingView, Context context) {
        this.iSayingView = iSayingView;
        iSayingModel = new SayingModel(context);
        handler = new MyHandler();
    }
    //完成Presenter层与View和Model层的连接

    public void doUpdateInfo() {
        iSayingModel.GetSaying(handler);
    }

    //收藏
    public void Collect(String content,String author){
        iSayingModel.Collection(content,author);
    }

    //取消收藏
    public void unCollect(String content){
        iSayingModel.unCollection(content);
    }

    public void isCollected(String content){
        iSayingModel.isCollected(content, new ISayingModel.Callback() {
            @Override
            public void onCollected() {
                iSayingView.setCollected();
            }

            @Override
            public void onUnCollected() {
                iSayingView.setUnCollected();
            }
        });
    }


    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //判断是由get返回的数据
            if (msg.what == 0) {
                SayingJson temp = (SayingJson) msg.obj;
                if (temp.success) {
                    iSayingView.setInfo(temp);
                } else {
                    iSayingView.showError(temp.message);
                }
            }
        }
    }
}
