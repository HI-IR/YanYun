package com.example.yanyun.login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yanyun.R;
import com.example.yanyun.login.presenter.LoginPresenter;
import com.example.yanyun.main.view.MainActivity;
import com.example.yanyun.registration.view.RegistrationActivity;

/**
 * description ： Login的View层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 17:42
 */

public class LoginActivity extends AppCompatActivity implements ILoginView {
    private ProgressBar mProgressBar;
    private EditText mEtUserName;
    private EditText mEtPassWord;
    private Button mBtnLogin;
    private CheckBox mCkRememberPassWord;
    private TextView mTvReg;
    private TextView mTvForget;
    private LoginPresenter mLoginPresenter;


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

        // 设置状态栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(android.graphics.Color.TRANSPARENT);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

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
                showLoading();
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

        mLoginPresenter = new LoginPresenter(this, this);
    }

    @Override
    public void showLoading() {
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
        Intent intent = new Intent(this, MainActivity.class);
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

    @Override
    public void check(boolean shouldRemember) {
        mCkRememberPassWord.setChecked(shouldRemember);
    }
}