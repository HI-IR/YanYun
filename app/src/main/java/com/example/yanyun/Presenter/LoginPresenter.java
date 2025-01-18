package com.example.yanyun.Presenter;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.Bean.Json.LoginJson;
import com.example.yanyun.Model.Login.Login.ILoginModel;
import com.example.yanyun.Model.Login.Login.LoginModel;
import com.example.yanyun.View.Login.ILoginView;

/**
 * description ： 登录的演示层，完成登录业务逻辑
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 20:11
 */
public class LoginPresenter {
    Handler handler=new Myhandler();
    ILoginView iLoginView;
    ILoginModel iLoginModel = new LoginModel();

    public LoginPresenter(ILoginView View) {
        iLoginView = View;
    }

    public void login(String username,String password){
        iLoginModel.login(username,password,handler);
    }


    private class Myhandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                iLoginView.hideLoading();
                LoginJson loginJson = LoginJson.decodeJson((String) msg.obj);
                //loginJson.errorCode:  -1失败   ， 0成功
                if (loginJson.errorCode==-1){
                    iLoginView.showError();
                }else{
                    iLoginView.doHome();
                }
            }
        }
    }

}
