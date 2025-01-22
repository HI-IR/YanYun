package com.example.yanyun;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Detail extends AppCompatActivity {
    private TextView mTitle;
    private TextView mContent;
    private TextView mDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
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
