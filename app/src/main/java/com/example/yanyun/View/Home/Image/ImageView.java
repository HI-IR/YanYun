package com.example.yanyun.View.Home.Image;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yanyun.R;

/**
 * description ： Home页的子Fragment--Image
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:39
 */
public class ImageView extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        return view;
    }
}
