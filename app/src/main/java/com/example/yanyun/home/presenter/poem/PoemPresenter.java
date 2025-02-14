package com.example.yanyun.home.presenter.poem;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.json.PoemJson;
import com.example.yanyun.home.model.poemModel.IPoemModel;
import com.example.yanyun.home.model.poemModel.PoemModel;
import com.example.yanyun.home.view.poem.IPoemView;

import java.lang.ref.WeakReference;


/**
 * description ： poem的Presenter层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 18:00
 */
public class PoemPresenter {
    IPoemModel iPoemModel;
    IPoemView iPoemView;
    Handler handler;

    public PoemPresenter(IPoemView iPoemView, Context context) {
        this.iPoemView = iPoemView;
        iPoemModel = new PoemModel(context);
        handler = new MyHandler(this);
    }

    public void doUpdateInfo() {
        iPoemModel.GetPoem(handler);
    }

     class MyHandler extends  Handler{
        WeakReference<PoemPresenter>  presenter;
        public MyHandler(PoemPresenter presenter) {
            super(Looper.getMainLooper());
            WeakReference<PoemPresenter> poemPresenterWeakReference = new WeakReference<>(presenter);
            this.presenter=poemPresenterWeakReference;
        }
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (msg.obj.equals("error")){
                    iPoemView.showError("网络错误，请稍后重试");
                }else{
                    PoemJson temp = (PoemJson) msg.obj;
                    if (temp.status.equals("success")) {
                        PoemPresenter poemPresenter = presenter.get();
                        if (poemPresenter!=null){
                            poemPresenter.iPoemView.setInfo(temp);
                        }
                    } else {
                        PoemPresenter poemPresenter = presenter.get();
                        if (poemPresenter!=null){
                            poemPresenter.iPoemView.showError(temp.status);
                        }
                    }
                }
            }
        }
    }

    //收藏
    public void Collect(String content,String author){
        iPoemModel.Collection(content,author);
    }

    //取消收藏
    public void unCollect(String content){
        iPoemModel.unCollection(content);
    }

    public void isCollected(String content){
        iPoemModel.isCollected(content, new IPoemModel.Callback() {
            @Override
            public void onCollected() {
                iPoemView.setCollected();
            }

            @Override
            public void onUnCollected() {
                iPoemView.setUnCollected();
            }
        });
    }
}
