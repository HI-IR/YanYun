package com.example.yanyun.registration.presenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.json.RegJson;
import com.example.yanyun.registration.model.IRegistrationModel;
import com.example.yanyun.registration.model.RegistrationModel;
import com.example.yanyun.registration.view.IRegView;

import java.lang.ref.WeakReference;


/**
 * description ： 实现注册业务逻辑
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/19 10:34
 */
public class RegPresenter {
    IRegView iRegView;
    IRegistrationModel iRegistrationModel;
    Handler handler;

    public RegPresenter(IRegView view) {
        iRegView = view;
        iRegistrationModel = new RegistrationModel();
        handler = new MyHandler(this);
    }

    public void doReg(String username, String password) {
        iRegistrationModel.doReg(username, password, handler);
    }

    public void onDataParsed(RegJson regJson) {
        if (regJson.errorCode == -1) {
            iRegView.showError(regJson.errorMsg);
        } else {
            iRegView.ToLogin();
        }
    }


    private class MyHandler extends android.os.Handler {
        WeakReference<RegPresenter> regPresenterWeakReference;

        public MyHandler(RegPresenter regPresenter) {
            super(Looper.getMainLooper());
            this.regPresenterWeakReference = new WeakReference<>(regPresenter);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (msg.obj.equals("error")){
                    iRegView.hideLoading();//取消加载条
                    iRegView.showError("网络错误，请稍后重试");
                }else {
                    iRegView.hideLoading();//取消加载条
                    onDataParsed((RegJson) msg.obj);
                }
            }
        }
    }


}
