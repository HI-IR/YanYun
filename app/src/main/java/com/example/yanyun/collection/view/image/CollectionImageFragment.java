package com.example.yanyun.collection.view.image;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.yanyun.R;
import com.example.yanyun.collection.presenter.Image.CollectionImageAdapter;
import com.example.yanyun.collection.presenter.Image.CollectionImagePresenter;
import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： 收藏Image的fragment
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 17:13
 */
public class CollectionImageFragment extends Fragment implements ICollectionImage {
    RecyclerView mRV;
    CollectionImagePresenter presenter;

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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection_image, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initView(View view) {
        mRV = view.findViewById(R.id.rv_collection_image);
        presenter = new CollectionImagePresenter(this);
    }

    private void initEvent() {
        presenter.doUpData();
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), "发生错误", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setAdapter(ArrayList<FavoriteEntity> favorites) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                mRV.setLayoutManager(layoutManager);
                mRV.setAdapter(new CollectionImageAdapter(favorites, presenter));
            }
        });

    }
}
