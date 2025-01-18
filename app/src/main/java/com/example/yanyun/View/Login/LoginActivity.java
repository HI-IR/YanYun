package com.example.yanyun.View.Login;
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

import com.example.yanyun.Presenter.LoginPresenter;
import com.example.yanyun.R;
import com.example.yanyun.View.Home.HomeActivity;

/**
 * description ： Login的View层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 17:42
 */

public class LoginActivity extends AppCompatActivity implements ILoginView{
    ProgressBar mProgressBar;
    EditText mEtUserName;
    EditText mEtPassWord;
    Button mBtnLogin;
    CheckBox mCkRememberPassWord;
    TextView mTvReg;
    TextView mTvForget;
    LoginPresenter mLoginPresenter;

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
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoging();
                mLoginPresenter.login(mEtUserName.getText().toString(),mEtPassWord.getText().toString());
            }
        });
    }

    private void initView() {
        mProgressBar=findViewById(R.id.progressBar);
        mEtUserName=findViewById(R.id.et_login_username);
        mEtPassWord=findViewById(R.id.et_login_password);
        mBtnLogin=findViewById(R.id.btn_login_login);
        mTvReg=findViewById(R.id.tv_login_reg);
        mCkRememberPassWord=findViewById(R.id.ck_login_remember);
        mTvForget=findViewById(R.id.tv_login_forget);

        mLoginPresenter= new LoginPresenter(this);
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
    public void doHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void doRegistration() {

    }

    @Override
    public void showError() {
        Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
    }
}