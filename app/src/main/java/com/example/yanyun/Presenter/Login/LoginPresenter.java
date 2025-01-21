package com.example.yanyun.Presenter.Login;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.Model.Bean.Json.LoginJson;
import com.example.yanyun.Model.Login.ILoginModel;
import com.example.yanyun.Model.Login.LoginModel;
import com.example.yanyun.View.Login.ILoginView;

import java.util.HashMap;

/**
 * description ： 登录的演示层，完成登录业务逻辑，记住密码
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

    //对网络数据进行处理
    public void onDataParsed(LoginJson loginJson) {
        iLoginView.hideLoading();
        if (loginJson.errorCode == -1) {
            iLoginView.showError(loginJson.errorMsg);
        } else {
            iLoginView.ToHome();
        }
    }

    @Override
    public void onLoginData(HashMap hashMap) {
        iLoginView.EnterInf((String) hashMap.get("KEY_USERNAME"), (String) hashMap.get("KEY_PASSWORD"));
        iLoginView.check((boolean) hashMap.get("KEY_REMEMBER_PASSWORD"));
    }


    public void rememberPassword(String username, String password, Boolean shouldRemember, Context context) {
        iLoginModel.rememberPassword(username, password, shouldRemember, context);
    }

    //获取保存的登录信息
    public void getLogin() {
        iLoginModel.getLogin(this, iLoginView.myGetContext());
    }


    private class Myhandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                onDataParsed((LoginJson) msg.obj);
            }
        }
    }

}
