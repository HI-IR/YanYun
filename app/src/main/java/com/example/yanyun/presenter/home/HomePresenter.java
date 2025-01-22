package com.example.yanyun.presenter.home;

import androidx.fragment.app.Fragment;

import com.example.yanyun.presenter.FragmentInterface;
import com.example.yanyun.view.home.history.HistoryView;
import com.example.yanyun.view.home.IHomeView;
import com.example.yanyun.view.home.image.ImageView;
import com.example.yanyun.view.home.poem.PoemView;
import com.example.yanyun.view.home.saying.SayingView;

import java.util.ArrayList;

/**
 * description ： HomeView的Presenter
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:24
 */
public class HomePresenter {
    IHomeView iHomeView;

    public HomePresenter(IHomeView view) {
        this.iHomeView = view;

    }


    //建立View层的连接

    //初始化Home页
    public void initView() {
        ArrayList<FragmentInterface> fragments = new ArrayList<>();
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new SayingView();
            }
        });
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new PoemView();
            }
        });
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new ImageView();
            }
        });
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new HistoryView();
            }
        });

        iHomeView.setAdapter(fragments);
    }


}
