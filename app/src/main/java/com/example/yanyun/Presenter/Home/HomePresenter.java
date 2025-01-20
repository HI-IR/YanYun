package com.example.yanyun.Presenter.Home;

import androidx.fragment.app.Fragment;

import com.example.yanyun.Presenter.FragmentInterface;
import com.example.yanyun.View.Home.IHomeView;
import com.example.yanyun.View.Home.Image.ImageView;
import com.example.yanyun.View.Home.Poem.PoemView;
import com.example.yanyun.View.Home.Saying.SayingView;

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
    public void initView(){
        ArrayList<FragmentInterface> fragments =new ArrayList<>();
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

        iHomeView.setAdapter(fragments);
    }


}
