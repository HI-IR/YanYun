package com.example.yanyun.View.Home.Saying;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yanyun.Model.Bean.Json.SayingJson;
import com.example.yanyun.Presenter.Home.Saying.SayingPresenter;
import com.example.yanyun.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * description ： Home页的子Fragment--Saying
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:40
 */
public class SayingView extends Fragment implements ISayingView {
    private TextView mContent;
    private TextView mFrom;
    private BottomNavigationView mBottomNavigationView;
    private ProgressBar mProgressBar;
    private SayingPresenter mSayingPresenter;
    private int clickCount = 0;//点击c次数

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saying, container, false);
        initView(view);
        initEvent();

        return view;
    }

    private void initEvent() {
        doUpdateInfo();

        //点击爱心收藏，TODO 暂未完全实现等待接入数据库
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_collection: {
                        clickCount++;
                        //如果点击数为奇数则显示收藏，为偶数则显示未收藏
                        int resourcesId = (clickCount % 2 == 1) ? R.drawable.collected : R.drawable.uncollected;
                        item.setIcon(resourcesId);
                        break;
                    }
                    case R.id.menu_refresh: {
                        doUpdateInfo();
                    }
                }
                return true;
            }
        });

    }

    private void initView(View view) {
        mContent = view.findViewById(R.id.tv_saying_content);
        mFrom = view.findViewById(R.id.tv_saying_from);
        mProgressBar = view.findViewById(R.id.progressBar_saying);
        mBottomNavigationView =view.findViewById(R.id.bottomNavigationView_saying);
        mSayingPresenter = new SayingPresenter(this);
        mBottomNavigationView.setItemIconTintList(null);
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
    public void doUpdateInfo() {
        showLoading();
        mSayingPresenter.doUpdateInfo();

    }

    public void setInfo(SayingJson sayingJson) {
        hideLoading();
        mContent.setText(sayingJson.data.hitokoto);
        mFrom.setText(sayingJson.data.from);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
