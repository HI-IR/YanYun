package com.example.yanyun.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.yanyun.FragmentInterface;
import com.example.yanyun.R;
import com.example.yanyun.home.presenter.HomePresenter;
import com.example.yanyun.home.presenter.HomeVp2Adapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

/**
 * description ： HomeView
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:11
 */
public class HomeActivity extends Fragment implements IHomeActivity {
    private TabLayout mTab;
    private ViewPager2 mVP2;
    private HomePresenter mHomePresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        mHomePresenter.initView();


        new TabLayoutMediator(mTab, mVP2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("言");
                } else if (position == 1) {
                    tab.setText("诗");
                } else if (position == 2) {
                    tab.setText("图");
                } else {
                    tab.setText("史");
                }
            }
        }).attach();


        return view;
    }

    private void initView(View view) {
        mHomePresenter = new HomePresenter(this);
        mTab = view.findViewById(R.id.tab_tablayout);
        mVP2 = view.findViewById(R.id.vp2_home);
    }

    @Override
    public void setAdapter(ArrayList<FragmentInterface> mFragments) {
        mVP2.setAdapter(new HomeVp2Adapter(HomeActivity.this, mFragments));
    }


}
