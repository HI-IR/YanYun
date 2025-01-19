package com.example.yanyun.View.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yanyun.Presenter.Login.LoginPresenter;
import com.example.yanyun.R;
import com.example.yanyun.View.Home.HomeActivity;
import com.example.yanyun.View.Registration.RegistrationActivity;

/**
 * description ： Login的View层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 17:42
 */

public class LoginActivity extends AppCompatActivity implements ILoginView {
    ProgressBar mProgressBar;
    EditText mEtUserName;
    EditText mEtPassWord;
    Button mBtnLogin;
    CheckBox mCkRememberPassWord;
    TextView mTvReg;
    TextView mTvForget;
    LoginPresenter mLoginPresenter;


    @Override
    protected void onResume() {
        super.onResume();
        mLoginPresenter.getLogin();
        if (getIntent().hasExtra("launchSource") && getIntent().getStringExtra("launchSource").equals("RegistrationActivity")) {
            String username = getIntent().getStringExtra("username");
            String password = getIntent().getStringExtra("password");
            EnterInf(username, password);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
    }

    /***
     * 设置点击事件
     */
    private void initEvent() {
        //登录按钮的点击事件
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoging();
                mLoginPresenter.login(mEtUserName.getText().toString(), mEtPassWord.getText().toString());
            }
        });

        //注册的点击事件
        mTvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mProgressBar = findViewById(R.id.progressBar);
        mEtUserName = findViewById(R.id.et_login_username);
        mEtPassWord = findViewById(R.id.et_login_password);
        mBtnLogin = findViewById(R.id.btn_login_login);
        mTvReg = findViewById(R.id.tv_login_reg);
        mCkRememberPassWord = findViewById(R.id.ck_login_remember);
        mTvForget = findViewById(R.id.tv_login_forget);

        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public void showLoging() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    //登录成功，进入Home页
    public void ToHome() {
        mLoginPresenter.rememberPassword(mEtUserName.getText().toString(), mEtPassWord.getText().toString(), shouldRemember(), this);
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }


    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void EnterInf(String username, String password) {
        mEtUserName.setText(username);
        mEtPassWord.setText(password);
    }

    @Override
    public boolean shouldRemember() {
        return mCkRememberPassWord.isChecked();
    }

    @Override
    public Context myGetContext() {
        return this;
    }
}