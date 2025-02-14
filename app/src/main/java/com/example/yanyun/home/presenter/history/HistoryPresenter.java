package com.example.yanyun.home.presenter.history;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.json.HistoryApiWapper;
import com.example.yanyun.json.HistoryJson;
import com.example.yanyun.home.model.historyModel.HistoryModel;
import com.example.yanyun.home.model.historyModel.IHistoryModel;
import com.example.yanyun.home.view.history.IHistoryView;
import java.lang.ref.WeakReference;

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
        handler = new MyHandler(this);
    }

    class MyHandler extends Handler {
        WeakReference<HistoryPresenter> presenter;

        public MyHandler(HistoryPresenter presenter) {
            super(Looper.getMainLooper());
            WeakReference<HistoryPresenter> historyPresenterWeakReference = new WeakReference<>(presenter);
            this.presenter=historyPresenterWeakReference;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (msg.obj.equals("error")){
                    iHistoryView.showError("网络错误，请稍后重试");
                }else{
                    HistoryApiWapper<HistoryJson> temp = (HistoryApiWapper<HistoryJson>) msg.obj;
                    if (temp.code==1){
                        presenter.get().iHistoryView.setInfo(temp);
                    }else{
                        iHistoryView.showError(temp.msg);
                    }
                }
            }
        }
    }
}
