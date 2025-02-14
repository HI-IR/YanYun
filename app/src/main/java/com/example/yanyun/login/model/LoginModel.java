package com.example.yanyun.login.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;

import com.example.yanyun.database.YanYunDatabase;
import com.example.yanyun.database.dao.UsersDao;
import com.example.yanyun.database.entity.UsersEntity;
import com.example.yanyun.json.LoginJson;
import com.example.yanyun.login.presenter.DataCallback;
import com.example.yanyun.utils.Net;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

/**
 * description ： 实现登录，实现登录Json的解析，实现记住密码（将是否记住密码、账号密码保存到本地），获取登录信息（保存目前是谁登录了）
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 21:16
 */
public class LoginModel implements ILoginModel {
    Context mContext;

    public LoginModel(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 登录
     * @param username 输入的用户名
     * @param password 输入的密码
     * @param handler presenter层传来的Handler
     */
    @Override
    public void login(String username, String password, Handler handler) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", username);
        hashMap.put("password", password);
        new Net().doPost("https://www.wanandroid.com/user/login", hashMap, handler, new TypeToken<LoginJson>(){}.getType());
    }

    /**
     * 记住密码
     * @param username  用户名
     * @param password  密码
     * @param shouldRemember    布尔值：是否需要记住密码
     * @param context   上下文
     */
    @Override
    public void rememberPassword(String username, String password, Boolean shouldRemember, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("KEY_REMEMBER_PASSWORD", shouldRemember);
        //保存密码和用户名，同时保存是否记住密码
        if (shouldRemember) {
            edit.putString("KEY_USERNAME", username);
            edit.putString("KEY_PASSWORD", password);
        } else {
            edit.putString("KEY_USERNAME", username);
            edit.putString("KEY_PASSWORD", "");
        }
        edit.apply();
    }

    /**
     * 获取登录信息
     * @param dataCallback
     * @param context
     */
    @Override
    public void getLogin(DataCallback dataCallback, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        HashMap hashMap = new HashMap<>();
        hashMap.put("KEY_REMEMBER_PASSWORD", sharedPreferences.getBoolean("KEY_REMEMBER_PASSWORD", false));
        hashMap.put("KEY_USERNAME", sharedPreferences.getString("KEY_USERNAME", ""));
        hashMap.put("KEY_PASSWORD", sharedPreferences.getString("KEY_PASSWORD", ""));
        dataCallback.onLoginData(hashMap);
    }

    /**
     * 在数据库中插入用户信息
     * @param loginJson 登录的jsonbean数据
     */
    @Override
    public void insertUser(LoginJson loginJson) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                YanYunDatabase db = YanYunDatabase.getDatabase();//打开数据库
                UsersDao usersDao = db.getUsersDao();//打开表

                String userName = usersDao.getUserName(loginJson.data.id);
                if(userName == null){
                    usersDao.InsertUser(new UsersEntity(loginJson.data.id,loginJson.data.publicName,loginJson.data.username));//增加登录数据
                }else{
                    Log.d("ld",loginJson.data.id+"");
                }
            }
        }).start();
    }

    //保存登录数据
    @Override
    public void saveLoginedUser(long user_id) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("loginedUser",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("LOGINED_USER",user_id);
        edit.apply();
    }
}
