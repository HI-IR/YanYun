package com.example.yanyun.view.collection.image;

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
import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.presenter.collection.Image.CollectionImageAdapter;
import com.example.yanyun.presenter.collection.Image.CollectionImagePresenter;
import com.example.yanyun.presenter.collection.poem.CollectionPoemAdapter;
import com.example.yanyun.presenter.collection.poem.CollectionPoemPresenter;

import java.util.ArrayList;

/**
 * description ： 收藏Image的fragment
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 17:13
 */
public class CollectionImage extends Fragment implements ICollectionImage{
    RecyclerView mRV;
    CollectionImagePresenter presenter;
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
        presenter=new CollectionImagePresenter(this);
    }

    private void initEvent() {
        presenter.doUpData();
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(),"发生错误",Toast.LENGTH_LONG).show();
    }

    @Override
    public void setAdapter(ArrayList<FavoriteEntity> favorites) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                mRV.setLayoutManager(layoutManager);
                mRV.setAdapter(new CollectionImageAdapter(favorites));
            }
        });

    }
}
