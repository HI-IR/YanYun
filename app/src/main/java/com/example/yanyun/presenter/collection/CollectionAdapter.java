package com.example.yanyun.presenter.collection;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.yanyun.presenter.FragmentInterface;
import com.example.yanyun.view.collection.CollectionActivity;

import java.util.ArrayList;

/**
 * description ： 收藏的Adapter
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 17:47
 */
public class CollectionAdapter extends FragmentStateAdapter {
    ArrayList<FragmentInterface> fragments;

    public CollectionAdapter(@NonNull CollectionActivity fragmentActivity,ArrayList<FragmentInterface> fragments) {
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
