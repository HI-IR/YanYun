package com.example.yanyun.home.presenter.saying;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.json.SayingJson;
import com.example.yanyun.home.model.sayingModel.ISayingModel;
import com.example.yanyun.home.model.sayingModel.SayingModel;
import com.example.yanyun.home.view.saying.ISayingFragment;

import java.lang.ref.WeakReference;

/**
 * description ： Saying的Presenter层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 16:21
 */
public class SayingPresenter {
    ISayingFragment iSayingView;
    ISayingModel iSayingModel;
    Handler handler;

    public SayingPresenter(ISayingFragment iSayingView, Context context) {
        this.iSayingView = iSayingView;
        iSayingModel = new SayingModel(context);
        handler = new MyHandler(this);
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
        public WeakReference<SayingPresenter> sayingPresenterWeakReference;

        public MyHandler(SayingPresenter sayingPresenter) {
            super(Looper.getMainLooper());
            this.sayingPresenterWeakReference = new WeakReference<>(sayingPresenter);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //判断是由get返回的数据
            if (msg.what == 0) {
                if (msg.obj.equals("error")){
                    iSayingView.showError("网络错误，请稍后重试");
                }else{
                    SayingJson temp = (SayingJson) msg.obj;
                    if (temp.success) {
                        sayingPresenterWeakReference.get().iSayingView.setInfo(temp);
                    } else {
                        sayingPresenterWeakReference.get().iSayingView.showError(temp.message);
                    }
                }
            }
        }
    }
}
