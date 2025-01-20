package com.example.yanyun.Presenter.Home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.yanyun.Presenter.FragmentInterface;
import com.example.yanyun.View.Home.HomeView;

import java.util.ArrayList;

/**
 * description ： Home页的ViewePager2的适配器
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:27
 */
public class HomeVp2Adapter extends FragmentStateAdapter {

    ArrayList<FragmentInterface> fragments;

    public HomeVp2Adapter(@NonNull HomeView fragmentActivity, ArrayList<FragmentInterface>fragments) {
        super(fragmentActivity);
        this.fragments=fragments;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position).back();
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
