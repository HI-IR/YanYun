package com.example.yanyun.Presenter.Home.History;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.Model.Bean.Json.HistoryJson;
import com.example.yanyun.Model.Home.HistoryModel.HistoryModel;
import com.example.yanyun.Model.Home.HistoryModel.IHistoryModel;
import com.example.yanyun.View.Home.History.IHistoryView;

/**
 * description ： History的Presenter层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/22 11:50
 */
public class HistoryPresenter {
    Handler handler;
    IHistoryModel iHistoryModel;
    IHistoryView iHistoryView;

    public void doUpdateInfo(){
        iHistoryModel.GetHistory(handler);
    }

    public HistoryPresenter(IHistoryView iHistoryView) {
        this.iHistoryView = iHistoryView;
        iHistoryModel = new HistoryModel();
        handler = new MyHandler();
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                HistoryJson temp = (HistoryJson) msg.obj;
                if (temp.code==1){
                    iHistoryView.setInfo(temp);
                }else{
                    iHistoryView.showError(temp.msg);
                }

            }
        }
    }
}
