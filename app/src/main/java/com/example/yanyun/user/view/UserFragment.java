package com.example.yanyun.user.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.yanyun.R;
import com.example.yanyun.collection.view.CollectionActivity;
import com.example.yanyun.user.presenter.UserPresenter;

import java.util.HashMap;

/**
 * description ： 用户界面View
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 20:01
 */
public class UserFragment extends Fragment implements IUserFragment {
    UserPresenter presenter;
    TextView mUserName;
    TextView mSayingCount;
    TextView mPoemCount;
    TextView mImageCount;
    CardView mCvToCollection;


    @Override
    public void onResume() {
        super.onResume();
        presenter.getUserInfo();
        if (getActivity() != null && getActivity().getWindow() != null) {
            // 设置状态栏颜色
            getActivity().getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));


            // 设置状态栏图标颜色（浅色背景用黑色图标）
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initEvent() {
        presenter.getUserInfo();

        mCvToCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CollectionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView(View view) {
        presenter = new UserPresenter(this);
        mUserName = view.findViewById(R.id.tv_user_id);
        mSayingCount = view.findViewById(R.id.tv_user_SayingCount);
        mPoemCount = view.findViewById(R.id.tv_user_PoemCount);
        mCvToCollection = view.findViewById(R.id.CV_user);
        mImageCount = view.findViewById(R.id.tv_user_ImageCount);
    }


    @Override
    public void setUserInfo(HashMap<String, String> counts) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mUserName.setText(counts.get("UserName")+"，你好！");
                mImageCount.setText(counts.get("ImageCount"));
                mPoemCount.setText(counts.get("PoemCount"));
                mSayingCount.setText(counts.get("SayingCount"));
            }
        });
    }
}
