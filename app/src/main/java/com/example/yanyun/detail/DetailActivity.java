package com.example.yanyun.detail;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yanyun.R;

public class DetailActivity extends AppCompatActivity {
    private TextView mTitle;
    private TextView mContent;
    private TextView mDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
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

    private void initEvent() {
        Intent intent = getIntent();

        mTitle.setText(intent.getStringExtra("title"));
        mContent.setText(intent.getStringExtra("content"));
        mDate.setText(intent.getStringExtra("date"));
    }

    private void initView() {
        mTitle = findViewById(R.id.tv_detail_title);
        mContent = findViewById(R.id.tv_detail_content);
        mDate = findViewById(R.id.tv_detail_date);
    }
}
