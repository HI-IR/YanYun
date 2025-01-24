package com.example.yanyun.presenter.home.poem;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.model.bean.json.PoemJson;
import com.example.yanyun.model.home.imageModel.IImageModel;
import com.example.yanyun.model.home.poemModel.IPoemModel;
import com.example.yanyun.model.home.poemModel.PoemModel;
import com.example.yanyun.view.home.poem.IPoemView;


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
        handler = new MyHandler();
    }

    public void doUpdateInfo() {
        iPoemModel.GetPoem(handler);
    }

    class MyHandler extends  Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                PoemJson temp = (PoemJson) msg.obj;
                if (temp.status.equals("success")) {

                    iPoemView.setInfo(temp);
                } else {
                    iPoemView.showError(temp.status);
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
