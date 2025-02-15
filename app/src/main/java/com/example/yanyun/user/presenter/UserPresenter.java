package com.example.yanyun.user.presenter;

import com.example.yanyun.user.model.IUserModel;
import com.example.yanyun.user.model.UserModel;
import com.example.yanyun.user.view.IUserFragment;

import java.util.HashMap;

/**
 * description ： User界面的Presenter
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 23:09
 */
public class UserPresenter {
    IUserModel iUserModel;
    IUserFragment iUser;

    public UserPresenter(IUserFragment iUser) {
        this.iUser = iUser;
        iUserModel = new UserModel();
    }

    //调用Model层去获取信息
    public void getUserInfo() {
        iUserModel.getUserInfo(new IUserModel.CallBack() {
            @Override
            public void onSuccess(HashMap<String, String> counts) {
                iUser.setUserInfo(counts);
            }
        });
    }

}
