package com.example.yanyun.home.view.saying;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yanyun.R;
import com.example.yanyun.home.presenter.saying.SayingPresenter;
import com.example.yanyun.json.SayingJson;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * description ： Home页的子Fragment--Saying
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:40
 */
public class SayingFragment extends Fragment implements ISayingFragment {
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

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null && getActivity().getWindow() != null) {
            // 设置状态栏颜色
            getActivity().getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

            // 设置状态栏图标颜色（浅色背景用黑色图标）
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    private void initEvent() {
        doUpdateInfo();

        //点击爱心收藏，
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_collection: {
                        clickCount++;
                        //如果点击数为奇数则显示收藏，为偶数则显示未收藏

                        if (clickCount % 2 == 1) {
                            item.setIcon(R.drawable.collected);
                            mSayingPresenter.Collect(mContent.getText().toString(), mFrom.getText().toString());
                        } else {
                            item.setIcon(R.drawable.uncollected);
                            mSayingPresenter.unCollect(mContent.getText().toString());
                        }
                        break;
                    }
                    case R.id.menu_refresh: {
                        doUpdateInfo();//更新数据
                        mBottomNavigationView.getMenu().findItem(R.id.menu_collection).setIcon(R.drawable.uncollected);//更新图标
                        clickCount = 0;
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
        mBottomNavigationView = view.findViewById(R.id.bottomNavigationView_saying);
        mSayingPresenter = new SayingPresenter(this, getContext());
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

    @Override
    public void setCollected() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBottomNavigationView.getMenu().findItem(R.id.menu_collection).setIcon(R.drawable.collected);
                clickCount = 1;
            }
        });

    }

    //设置未收藏状态（因为是其他线程回调而来的所以需要切换一下线程）
    @Override
    public void setUnCollected() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBottomNavigationView.getMenu().findItem(R.id.menu_collection).setIcon(R.drawable.uncollected);
                clickCount = 0;
            }
        });
    }
}
