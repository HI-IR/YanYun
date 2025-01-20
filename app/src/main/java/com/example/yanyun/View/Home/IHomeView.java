package com.example.yanyun.View.Home;

import com.example.yanyun.Presenter.FragmentInterface;

import java.util.ArrayList;

/**
 * description ： HomeVie的接口
 * 设置ViewPager2的适配器
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:26
 */
public interface IHomeView {
    void setAdapter(ArrayList<FragmentInterface> mFragments);

}
