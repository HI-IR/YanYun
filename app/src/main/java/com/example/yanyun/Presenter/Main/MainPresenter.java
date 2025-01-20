package com.example.yanyun.Presenter.Main;

import androidx.fragment.app.Fragment;

import com.example.yanyun.Presenter.FragmentInterface;
import com.example.yanyun.View.Home.HomeView;
import com.example.yanyun.View.Main.IMainView;
import com.example.yanyun.View.Other.OtherView;
import com.example.yanyun.View.User.UserView;

import java.util.ArrayList;

/**
 * description ： TODO:类的作用
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 20:13
 */
public class MainPresenter {
    IMainView iMainView;

    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;

    }

    //初始化MainActivity
    public void initMain(){
        ArrayList<FragmentInterface>fragments=new ArrayList<>();
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new HomeView();
            }
        });
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new OtherView();
            }
        });
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new UserView();
            }
        });
        iMainView.setAdapter(fragments);

    }

    //当ViewPager2的其他页面被选中时
    public void onPagerSelected(int position){
        iMainView.menuChanged(position);
    }

}
