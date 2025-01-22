package com.example.yanyun.presenter.home.history;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.model.bean.json.HistoryJson;
import com.example.yanyun.model.home.historyModel.HistoryModel;
import com.example.yanyun.model.home.historyModel.IHistoryModel;
import com.example.yanyun.view.home.history.IHistoryView;

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
