package com.example.yanyun.View.Home.Saying;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yanyun.R;

/**
 * description ： Home页的子Fragment--Saying
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:40
 */
public class SayingView extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saying, container, false);
        return view;
    }
}
