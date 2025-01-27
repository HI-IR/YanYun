package com.example.yanyun.home.presenter;

import androidx.fragment.app.Fragment;

import com.example.yanyun.FragmentInterface;
import com.example.yanyun.home.view.history.HistoryFragment;
import com.example.yanyun.home.view.IHomeActivity;
import com.example.yanyun.home.view.image.ImageFragment;
import com.example.yanyun.home.view.poem.PoemFragment;
import com.example.yanyun.home.view.saying.SayingFragment;

import java.util.ArrayList;

/**
 * description ： HomeView的Presenter
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:24
 */
public class HomePresenter {
    IHomeActivity iHomeActivity;

    public HomePresenter(IHomeActivity view) {
        this.iHomeActivity = view;

    }


    //建立View层的连接

    //初始化Home页
    public void initView() {
        ArrayList<FragmentInterface> fragments = new ArrayList<>();
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new SayingFragment();
            }
        });
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new PoemFragment();
            }
        });
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new ImageFragment();
            }
        });
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new HistoryFragment();
            }
        });

        iHomeActivity.setAdapter(fragments);
    }


}
