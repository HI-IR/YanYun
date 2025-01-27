package com.example.yanyun.collection.view;

import com.example.yanyun.FragmentInterface;

import java.util.ArrayList;

/**
 * description ： Collection页面的接口
 * 设置适配器
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 17:37
 */
public interface ICollectionActivity {
    void setAdapter(ArrayList<FragmentInterface> mFragments);
}
