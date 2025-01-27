package com.example.yanyun.main.presenter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.yanyun.FragmentInterface;

import java.util.ArrayList;

/**
 * description ： Main页面的ViewPager2的适配器
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 20:16
 */
public class MainVp2Adapter extends FragmentStateAdapter {
    ArrayList<FragmentInterface> fragments;


    public MainVp2Adapter(@NonNull FragmentActivity fragmentActivity, ArrayList<FragmentInterface> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
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
