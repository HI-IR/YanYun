package com.example.yanyun.collection.view.poem;

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
import com.example.yanyun.collection.presenter.poem.CollectionPoemAdapter;
import com.example.yanyun.collection.presenter.poem.CollectionPoemPresenter;
import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： 收藏Poem的fragment
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 17:11
 */
public class CollectionPoemFragment extends Fragment implements ICollectionPoem {
    RecyclerView mRV;
    CollectionPoemPresenter presenter;
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
        View view = inflater.inflate(R.layout.fragment_collection_poem, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initEvent() {
        presenter.doUpData();
    }

    private void initView(View view) {
        mRV = view.findViewById(R.id.rv_collection_poem);
        presenter = new CollectionPoemPresenter(this);
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
                mRV.setAdapter(new CollectionPoemAdapter(favorites, presenter));
            }
        });
    }
}
