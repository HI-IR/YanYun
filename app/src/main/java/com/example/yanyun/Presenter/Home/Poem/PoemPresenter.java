package com.example.yanyun.Presenter.Home.Poem;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.Model.Bean.Json.PoemJson;
import com.example.yanyun.Model.Home.PoemModel.IPoemModel;
import com.example.yanyun.Model.Home.PoemModel.PoemModel;
import com.example.yanyun.View.Home.Poem.IPoemView;


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

    public PoemPresenter(IPoemView iPoemView) {
        this.iPoemView = iPoemView;
        iPoemModel = new PoemModel();
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
}
