package com.example.yanyun.Presenter.Main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.yanyun.Presenter.FragmentInterface;

import java.util.ArrayList;

/**
 * description ： TODO:类的作用
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 20:16
 */
public class MainVp2Adapter extends FragmentStateAdapter {
    ArrayList<FragmentInterface> fragments;


    public MainVp2Adapter(@NonNull FragmentActivity fragmentActivity,ArrayList<FragmentInterface>fragments) {
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
