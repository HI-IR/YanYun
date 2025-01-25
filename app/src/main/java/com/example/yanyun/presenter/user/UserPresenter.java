package com.example.yanyun.presenter.user;

import com.example.yanyun.model.user.IUserModel;
import com.example.yanyun.model.user.UserModel;
import com.example.yanyun.view.user.IUser;

import java.util.HashMap;

/**
 * description ： TODO:类的作用
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 23:09
 */
public class UserPresenter {
    IUserModel iUserModel;
    IUser iUser;

    public UserPresenter(IUser iUser) {
        this.iUser = iUser;
        iUserModel = new UserModel();
    }

    public void getUserInfo(){
        iUserModel.getUserInfo(new IUserModel.CallBack() {
            @Override
            public void onSuccess(HashMap<String, String> counts) {
                iUser.setUserInfo(counts);
            }
        });
    }

}
