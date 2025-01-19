package com.example.yanyun.Presenter.Login;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.Model.Bean.Json.LoginJson;
import com.example.yanyun.Model.Login.ILoginModel;
import com.example.yanyun.Model.Login.LoginModel;
import com.example.yanyun.View.Login.ILoginView;

/**
 * description ： 登录的演示层，完成登录业务逻辑
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 20:11
 */
public class LoginPresenter implements DataCallback {
    Handler handler = new Myhandler();
    ILoginView iLoginView;
    ILoginModel iLoginModel = new LoginModel();

    public LoginPresenter(ILoginView View) {
        iLoginView = View;
    }

    public void login(String username, String password) {
        iLoginModel.login(username, password, handler);
    }

    //接收 Model 层解析后的数据
    @Override
    public void onDataParsed(LoginJson loginJson) {
        iLoginView.hideLoading();
        if (loginJson.errorCode==-1){
            iLoginView.showError(loginJson.errorMsg);
        }else{
            iLoginView.ToHome();
        }

    }


    private class Myhandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                iLoginModel.parseJson((String) msg.obj,LoginPresenter.this);
            }
        }
    }

}
