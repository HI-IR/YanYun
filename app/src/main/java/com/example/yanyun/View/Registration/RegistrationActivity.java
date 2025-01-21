package com.example.yanyun.View.Registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yanyun.Presenter.Registration.RegPresenter;
import com.example.yanyun.R;
import com.example.yanyun.View.Login.LoginActivity;

public class RegistrationActivity extends AppCompatActivity implements IRegView {
    EditText mEtUsername;
    EditText mEtPassword;
    Button mBtnReg;
    ProgressBar mProgressBar;
    RegPresenter mRegPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();
        initEvent();
    }

    private void initEvent() {
        mBtnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();//显示加载条
                mRegPresenter.doReg(mEtUsername.getText().toString(), mEtPassword.getText().toString());
            }
        });
    }

    private void initView() {
        mEtUsername = findViewById(R.id.et_reg_username);
        mEtPassword = findViewById(R.id.et_reg_password);
        mBtnReg = findViewById(R.id.btn_reg_reg);
        mRegPresenter = new RegPresenter(this);
        mProgressBar = findViewById(R.id.reg_progressBar);
    }

    @Override
    public void ToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("username", mEtUsername.getText().toString());
        intent.putExtra("password", mEtPassword.getText().toString());
        intent.putExtra("launchSource", "RegistrationActivity");//用来在Login中判断是从RegistrationActivity中跳转而来
        startActivity(intent);
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
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}