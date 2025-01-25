package com.example.yanyun.presenter.main;

import androidx.fragment.app.Fragment;

import com.example.yanyun.presenter.FragmentInterface;
import com.example.yanyun.view.home.HomeActivity;
import com.example.yanyun.view.main.IMainView;
import com.example.yanyun.view.other.OtherView;
import com.example.yanyun.view.user.UserView;

import java.util.ArrayList;

/**
 * description ： MainView的Presenter
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
    public void initMain() {
        ArrayList<FragmentInterface> fragments = new ArrayList<>();
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new HomeActivity();
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
    public void onPagerSelected(int position) {
        iMainView.menuChanged(position);
    }

}
