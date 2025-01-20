package com.example.yanyun.View.Main;

import com.example.yanyun.Presenter.FragmentInterface;

import java.util.ArrayList;

/**
 * description ： MainView的接口
 * 根据BottomNavigation切换View,底部菜单栏颜色状态改变
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 20:08
 */
public interface IMainView {
    void setAdapter(ArrayList<FragmentInterface> mFragments);
    void menuChanged(int position);//底部菜单栏颜色状态改变
}
