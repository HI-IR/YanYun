package com.example.yanyun.main.presenter;

import androidx.fragment.app.Fragment;

import com.example.yanyun.FragmentInterface;
import com.example.yanyun.home.view.HomeFragment;
import com.example.yanyun.main.view.IMainView;
import com.example.yanyun.user.view.UserFragment;

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
                return new HomeFragment();
            }
        });
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new UserFragment();
            }
        });
        iMainView.setAdapter(fragments);

    }

    //当ViewPager2的其他页面被选中时
    public void onPagerSelected(int position) {
        iMainView.menuChanged(position);
    }

}
