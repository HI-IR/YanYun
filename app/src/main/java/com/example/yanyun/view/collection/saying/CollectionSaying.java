package com.example.yanyun.view.collection.saying;
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
import androidx.viewpager2.widget.ViewPager2;

import com.example.yanyun.R;
import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.presenter.FragmentInterface;
import com.example.yanyun.presenter.collection.saying.CollectionSayingAdapter;
import com.example.yanyun.presenter.collection.saying.CollectionSayingPresenter;
import com.example.yanyun.presenter.home.HomePresenter;
import com.example.yanyun.presenter.home.HomeVp2Adapter;
import com.example.yanyun.view.collection.ICollectionActivity;
import com.example.yanyun.view.home.HomeActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * description ： 收藏saying的fragment
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 17:04
 */
public class CollectionSaying extends Fragment implements ICollectionSaying{
    RecyclerView mRV;
    CollectionSayingPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection_saying, container, false);
        initView(view);
        initEvent();


        return view;
    }

    private void initEvent() {
        presenter.doUpData();
    }

    private void initView(View view) {
        mRV = view.findViewById(R.id.rv_collection_saying);
        presenter = new CollectionSayingPresenter(this);
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
                mRV.setAdapter(new CollectionSayingAdapter(favorites));
            }
        });
    }
}
