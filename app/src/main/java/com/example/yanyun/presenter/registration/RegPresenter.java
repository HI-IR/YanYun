package com.example.yanyun.presenter.registration;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.model.bean.json.RegJson;
import com.example.yanyun.model.registration.IRegistrationModel;
import com.example.yanyun.model.registration.RegistrationModel;
import com.example.yanyun.view.registration.IRegView;


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
        handler = new MyHandler();
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
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                iRegView.hideLoading();//取消加载条
                onDataParsed((RegJson) msg.obj);
            }
        }
    }


}
