package com.example.yanyun.View.Other;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yanyun.R;

/**
 * description ： 发现页View---发现页用来存放其他的小工具，随时增加
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 20:01
 */
public class OtherView extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other, container, false);
        return view;
    }
}
